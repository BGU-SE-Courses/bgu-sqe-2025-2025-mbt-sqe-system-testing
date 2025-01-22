/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to google.com, and searches for "Pizza".
 */
// bthread('Search', function () {
//   let s = new SeleniumSession('search').start(URL)
//   composeQuery(s, { text: 'Pizza' })
//   startSearch(s)
// })

bthread('Admin Cancels Coupon', function () {
  let session = new SeleniumSession('admin');
  session.start(URLADMIN);
  loginAsAdmin(session);
  navigateToCoupons(session);
  disableCoupon(session);
});

/**
 * This story opens a new browser window, goes to google.com, and searches for "Pasta" using the "I Feel Lucky" feature.
 */
// bthread('Feeling lucky', function () {
//   let s = new SeleniumSession('lucky').start(URL)
//   composeQuery(s, { text: 'Pasta' })
//   feelLucky(s)
// })