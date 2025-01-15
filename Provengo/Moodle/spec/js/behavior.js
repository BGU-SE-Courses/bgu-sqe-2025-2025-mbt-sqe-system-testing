/* @provengo summon selenium */



/**
 * This story opens a new browser window, goes to google.com, and searches for "Pizza".
 */
bthread('Student attempts a change his choice', function () {
  sync({waitFor:Event("End(create_choice)")})
    interrupt( Event("Middle(disable_change_choice)"),function(){
        let s1 = new SeleniumSession();
        s1.start();
        navigate_to_login(s1);
        enter_login_info(s1);
        click_login(s1);
        navigate_to_coursePage(s1);
        select_choice(s1);
        select_choice_option(s1);
        submit_choice(s1);
        change_choice_option(s1);
        submit_choice(s1);
    }) 
})


/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to google.com, and searches for "Pizza".
 */
bthread('Search', function () {
    let s = new SeleniumSession('search');
    s.start(URL);
    composeQuery(s, { text: 'Pizza' })
    startSearch(s)
})

/**
 * This story opens a new browser window, goes to google.com, and searches for "Pasta" using the "I Feel Lucky" feature.
 */
bthread('Feeling lucky', function () {
    let s = new SeleniumSession('lucky');
    s.start(URL);
    composeQuery(s, { text: 'Pasta' })
    feelLucky(s)
})