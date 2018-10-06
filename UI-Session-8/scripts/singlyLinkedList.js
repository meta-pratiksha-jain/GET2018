function node(data) {
    this.data = data;
    this.next = null;
}

function singlyLinkedList() {
    this.head = null;
    this.length = 0;

    //function to add an element
    this.add = function add(element) {
        var newNode = new node(element);
        if (!this.head) {
            this.head = newNode;
        } else {
            var currentNode = this.head;
            while (currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        this.length++;
        return newNode;
    }

    //function to delete an element at index
    this.remove = function remove(index) {
        if (index < 0 || index > this.length - 1) {
            return "invalid index";
        }
        if (index == 0) {
            var deletedNode = this.head;
            this.head = this.head.next;
            this.length--;
            return deletedNode;
        }
        var count = 1;
        var currentNode = this.head.next;
        var previousNode = this.head;
        while (count < index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            count++;
        }
        previousNode.next = currentNode.next;
        this.length--;
        return currentNode;
    }

    //function to print list
    this.printList = function display() {
        var currentNode = this.head;
        var list = "";
        while (currentNode) {
            list = list + currentNode.data + " ";
            currentNode = currentNode.next;
        }
        console.log(list);
    }
}
