const core = () => { 
  let menuIsOpen = false;
  let casesMenuIsOpen = false;
  let verticalNav = document.getElementById('vertical-nav');
  let casesMenu = document.getElementById('cases-menu');
  let unfocus = document.getElementById('unfocus');
  verticalNav.style.left = "-12em";  
  casesMenu.style.display= "none";   
  unfocus.style.display= "none";  
  
  let currentYear = new Date().getFullYear();
  document.getElementById("foot").innerHTML = `&#169; ${currentYear} DM88`;

  let clockwork = new TimelineMax();
  clockwork.staggerTo("#clockwork > g:nth-of-type(2n)", 6, {transformOrigin:"center",rotation:"360", ease:Linear.easeNone, repeat:-1},"-0.1")
  .staggerTo("#clockwork > g:nth-of-type(2n+1)", 8, {transformOrigin:"center",rotation:"-360", ease:Linear.easeNone, repeat:-1},"-0.1",0)
  .staggerTo("#clockwork > path", 7, {transformOrigin:"center",rotation:"-360", ease:Linear.easeNone, repeat:-1},"-0.1",0);

 let browsersHaveAppeared = false; 
  
  window.addEventListener("scroll", () => {
    let browsersDiv = document.getElementById("browsers");
    let browsersDivTop = browsersDiv.getBoundingClientRect().top;
    let windowHeight = window.innerHeight;
    
    if (browsersDivTop < (windowHeight-200) && !browsersHaveAppeared) {
      let browsers = new TimelineMax();
      browsers.staggerTo(".browsers > div", 1, {opacity:1}, "0.2");
      browsersHaveAppeared = true;
    }
  });

  
  
    toggleCasesMenu = () => {
      if (casesMenuIsOpen) {
        casesMenuIsOpen = false;  
        casesMenu.style.display= "none";   
        return;
      }
      casesMenuIsOpen = true;    
      casesMenu.style.display= "block";   
    }
  
    toggleMenu = () => {
      if (menuIsOpen) {
        menuIsOpen = false;
        verticalNav.style.left = "-12em";  
        unfocus.style.display= "none";  
        fromXMenu();
        return;
      }
      verticalNav.style.left = "0em";
      unfocus.style.display= "block";  
      menuIsOpen = true;
      toXMenu();
    }
  
    waverMenu = () => {
      if (menuIsOpen) return;
      let waver = new TimelineMax();
      waver.staggerTo("#burger > rect", 0.2, {x:"20px", yoyo:true, repeat:2, ease:"ease-out"},"-0.1")
      .staggerTo("#burger > rect", 0.2, {x:"0",ease:"ease-out"}, "-0.1")
   }   
  
    toXMenu = () => {
      let x = new TimelineMax();
      x.to("#burger > rect:nth-of-type(2)", 0.2, {scaleX:0})
      .to("#burger > rect:first-of-type", 0.2, {rotation:"32deg", y:"-10px", scaleX:"1.1", transformOrigin: "left"})
      .to("#burger > rect:last-of-type", 0.2, {scaleX:"1.1",rotation:"-32deg", transformOrigin: "left"})
    }
    
    fromXMenu = () => {
      let x = new TimelineMax();
      x.to("#burger > rect:first-of-type", 0.2, {rotation:"0", y:"0", scaleX:"1", transformOrigin: "left"})
      .to("#burger > rect:last-of-type", 0.2, {scaleX:"1",rotation:"0", transformOrigin: "left"})
      .to("#burger > rect:nth-of-type(2)", 0.2, {scaleX:1})
    }
}


document.addEventListener("DOMContentLoaded", core());