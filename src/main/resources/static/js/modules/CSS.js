class CSS {
    static set(element, styles) {
        // 객체로 받은 스타일 element에 넣어주기
        for(let key in styles) {
            element.style[key] = styles[key];
        }
    }
}

export default CSS;