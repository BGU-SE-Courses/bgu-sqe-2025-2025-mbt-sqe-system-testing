/* @provengo summon selenium */

/**
 * This story simulates the admin setting product quantity to 0.
 */
bthread('Admin sets product quantity to 0', function () {
  let s = new SeleniumSession('admin')
  s.start(adminURL) // Update with your actual admin URL
  adminLogin(s)
  setProductQuantity(s, { product: 'Product Name', quantity: '0' })
  s.close()
})
