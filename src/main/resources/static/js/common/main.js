
/* 메인 페이지 */
import CSS from "../modules/CSS.js";

/* 메인 - animal 섹션 코드 */
window.addEventListener("load", (e)=>{
    let animalSection = document.querySelector("#animal");
    let animalBtn = animalSection.querySelector(".animal-btn");
    let bgImg = animalSection.querySelector(".background-img");
    animalBtn.addEventListener("mouseenter",(e)=>{
        console.log("enter");
        CSS.set(bgImg, {
            transform: "scale(1.1)"
        });
    });
    animalBtn.addEventListener("mouseleave",(e)=>{
        console.log("leave");
        CSS.set(bgImg, {
            transform: "scale(1.0)"
        });
    });
});
