import CSS from "../modules/CSS.js";

class ScrollHeader {
    #header;
    #isTop;
    constructor(header) {
        if(typeof header === 'string') {
            this.#header = document.querySelector(header);
        } else {
            this.#header = header;
        }

        // 처음에는 투명
        this.#header.classList.add("transparent");

        this.#isTop = true;
        window.addEventListener("scroll", this.#scrollHandler.bind(this));
    }

    #scrollHandler(e) {
        console.log("window.scrollY : "+window.scrollY);
        if(window.scrollY > 80) {
            if(this.#isTop == true) {
                this.#isTop = false;
                this.#header.classList.remove("transparent");
            }
        } else {
            if(this.#isTop == false) {
                this.#isTop = true;
                this.#header.classList.add("transparent");
            }
        }
    }
}

export default ScrollHeader;