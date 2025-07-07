class Talk {
    name ;
    constructor(na){
        this.name = na ;
    }
    talk(){
        return this.name ;
    }
}

const me = new Talk("uday");
console.log(me.talk());
