/* @provengo summon selenium */
// @provengo summon ctrl

/**
 * This story simulates the admin setting product quantity to 0.
 */
const session = new SeleniumSession('testSession',  'chrome' ); // or 'firefox'

bthread('Admin sets product quantity to 0', function () {
  try {
    bp.log.info('Starting admin session...');
    session.start(adminURL); // Update with your actual admin URL

    bp.log.info('Logging in as admin...');
    adminLogin(session);

    bp.log.info('Setting product quantity to 0...');
    setProductQuantity(session, { product: 'Product Name', quantity: '0' });
  } catch (error) {
    bp.log.warn(`An error occurred: ${error.message}`);
  } finally {
    bp.log.info('Closing admin session...');
    session.close();
  }
});
