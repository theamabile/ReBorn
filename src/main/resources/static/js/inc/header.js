
/* 메인 페이지 */
import Header from "../../modules/ScrollHeader.js";

window.addEventListener("load", (e)=>{
    let header = document.querySelector("header");
    let scrollHeader = new Header(header);
});
