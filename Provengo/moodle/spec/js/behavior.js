/* @provengo summon selenium */

// bthread('Restore Moodle Database Before Test', function () {
//   bp.log.info("Restoring Moodle Database to Previous State...");

//   try {
//       // Command needs to be properly structured for Java execution
//       let command = [
//           "C:\\Users\\Hmode\\Desktop\\Msalha\\MoodleWindowsInstaller-latest\\server\\mysql\\bin\\mysql",
//           "-u", "root",
//           "moodle",
//           "-e", "source C:/Users/Hmode/Desktop/Msalha/moodle_backup.sql"
//       ];

//       let process = new java.lang.ProcessBuilder(command).start();
//       process.waitFor();  // Wait for command to finish

//       bp.log.info("Moodle database restored successfully.");
//   } catch (error) {
//       bp.log.info("Error restoring database: " + error);
//   }
// });






let session = new SeleniumSession("Ahiya");
let session1 = new SeleniumSession("Keren");

bthread('LoginAndDestroyKeren', function() {
  session.start(URL);
  session.loginAndGoToCourseA({ email: "123", password: "123" });
  session.degradeKerenToStudent({ email: "123", password: "123" });

  // Signal degradation completion
  sync({ request: Event("DegradeCompleted") });
});

bthread('LoginAndTryToAddNewContent', function() {
  session1.start(URL);
  session1.loginAndGoToCourseK({ email: "123", password: "123" });
  session1.tryToAddNewContent({ email: "123", password: "123" });

  // Signal content addition completion
  sync({ request: Event("ContentAdded") });
});

bthread('EnsureConfirmation', function() {
  // Wait for EITHER event to happen before proceeding
  sync({
    waitFor: [Event("DegradeCompleted"), Event("ContentAdded")]
  });

  // Ensure BOTH events have completed before confirming degradation
  sync({
    waitFor: [
      Event("DegradeCompleted"),
      Event("ContentAdded")
    ]
  });

  // Now confirm the degradation
  session.confirmDestruction({ email: "123", password: "123" });
});
