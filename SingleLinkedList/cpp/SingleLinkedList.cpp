#include <iostream>
using namespace std;

/**
 * A single linked list.
 */
class SingleLinkedList {
  
    private:
        /**
         * A node of a single linked list.
         */
        class Node
        {
        public:
            int data;
            Node *next;

            Node(int data)
            {
                this->data = data;
            }
        };

        Node * head;
        Node * tail;

    public:

        /**
         * Adds an object to the start of the linked list.
         */
        void push(int data) 
        {
            // create a new instance of a node
            Node * newNode = new Node(data);

            if (!head)
            {
                // the linked list is empty, so fill it in
                head = newNode;
                tail = newNode;
            }
            else
            {
                // add the node to the start of the linked list
                newNode->next = head;
                head = newNode;
            }
        }

        /**
         * Adds an object to the end of the linked list.
         */
        void append(int data)
        {
            // create a new instance of a node
            Node * newNode =  new Node(data);

            if (!head)
            {
                // the linked list is empty, so fill it in
                head = newNode;
                tail = newNode;
            }
            else
            {
                // add the node to the end of the linked list
                tail->next = newNode;
                tail = newNode;
            }
        }

        /**
         * Adds an object to the end of the linked list.
         */
        int pop()
        {
            // set current node to be the frontmost node
            Node * current = head;

            // loop until the current node is the second last node in the linked list
            while (current->next->next)
            {
                current = current->next;
            }

            // grab tail object for output
            int output = tail->data;

            // remove pointer to the current tail and set tail to second last node
            delete current->next;
            tail = current;

            return output;

        }

        /**
         * Prints out all the objects in the linked list.
         */
        void traverse()
        {
            // set the current node to be the frontmost node
            Node * current = head;

            // loop and output the objects until the very last node
            while (current->next) 
            {
                cout << current->data << ", ";
                current = current->next;
            }
            cout << current->data;
        }
};

int main() {
    SingleLinkedList sll = SingleLinkedList();
    sll.append(1);
    sll.append(2);
    sll.append(3);
    sll.pop();
    sll.append(4);

    sll.traverse();
    return 0;
}