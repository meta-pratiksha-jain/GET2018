function node(data) {
    this.data = data;
    this.next = null;
    this.previous = null;
}

function doublyLinkedList() {
    this.head = null;
    this.length = 0;

    //function to add an element in list
    this.add = function (element) {
        var newNode = new node(element);
        if (!this.head) {
            this.head = newNode;
        } else {
            var currentNode = this.head;
            while (currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.previous = currentNode;
        }
        this.length++;
        return newNode;
    }

    //function to delete an element at position index from the list 
    this.remove = function (index) {
        if (index < 0 || index > this.length - 1) {
            return "invalid index";
        }
        if (index == 0) {
            var deletedNode = this.head;
            this.head = this.head.next;
            this.head.previous = null;
            this.length--;
            return deletedNode;
        }
        var count = 1;
        var currentNode = this.head.next;
        while (count < index) {
            currentNode = currentNode.next;
            count++;
        }
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
        this.length--;
        return currentNode;
    }

    //function to print list
    this.printList = function () {
        var currentNode = this.head;
        var list = "";
        while (currentNode) {
            list = list + currentNode.data + " ";
            currentNode = currentNode.next;
        }
        console.log(list);
    }
}
