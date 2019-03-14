/*****************************************************
 * 
 * 
 * 
 * 
 * 
 * 
 */


var menu = document.getElementsByClassName('control-menu')[0];

menu.childNodes.forEach((e) => {
   e.addEventListener("click", function() {
      this.parentNode.childNodes.forEach((e)=>{
         e.className = 'items'
      })
      this.className = 'items cur'
   })
})