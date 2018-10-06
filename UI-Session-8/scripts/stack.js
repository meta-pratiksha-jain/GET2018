function stack() {
    this.topOfStack = 0;
    this.data = {};
}

//function to push an element into stack
stack.prototype.push = function (element) {
    var size = ++this.topOfStack;
    this.data[size] = element;
}

//function to pop from stack
stack.prototype.pop = function () {
    var size = this.topOfStack;
    if (size) {
        var deletedElement = this.data[size];
        delete this.data[size];
        this.topOfStack--;
        return deletedElement;
    }
    return "stack is empty";
}
