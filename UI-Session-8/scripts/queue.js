function queue() {
    this.front = 0;
    this.rear = 0;
    this.data = {};
}

//function to enqueue an element
queue.prototype.enqueue = function (element) {
    this.data[++this.rear] = element;
    if (this.front == 0) {
        this.front++;
    }
}

//function to dequeue from queue
queue.prototype.dequeue = function () {
    if (this.front == 0 || (this.front > this.rear)) {
        return "queue is empty";
    }
    var element = this.data[this.front];
    delete this.data[this.front];
    this.front++;
    return element;
}
