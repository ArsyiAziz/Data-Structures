#include "HashTable.hpp"
#include <stdio.h>
#include <stdexcept>
#include <string>

HashEntry::HashEntry(int key, int value) {
    this->key = key;
    this->value = value;
}

HashTable::HashTable(int capacity) {
    this->capacity = capacity;
    this->elements = new HashEntry*[capacity]();
    this->currSize = 0;
}

int HashTable::hashFunc(int key) const {
    //Shift folding

    int remainder = key;
    int h = 0;
    while (remainder > 0) {
        h += remainder%100;
        remainder /= 100;
    }
    return h % capacity;
}

bool HashTable::lookup(int key) const {
    int h = hashFunc(key);
    int counter = 0;
    while (elements[h] != NULL && elements[h]->key != key && counter < capacity) {
        h = (h + 1) % capacity;
        counter++;
    }

    if (elements[h] == NULL) {
        return false;
    } else {
        return true;
    }
}

void HashTable::insert(int key, int value) {
    int h = hashFunc(key);
    if (currSize == capacity) {
        std::string message = "Hash table has exceeded capacity of size: " + std::to_string(capacity);
        throw std::length_error(message);
    }
    while (elements[h] != NULL && elements[h]->key != key) {
        h = (h + 1) % capacity;
    }    
    elements[h] = new HashEntry(key, value);
    currSize++;
}

int HashTable::get(int key) const{
    int h = hashFunc(key);
    int counter = 0;
    while (elements[h] != NULL && elements[h]->key != key && counter < capacity)
    {
        h = (h + 1) % capacity;
        counter++;
    }

    if (elements[h] == NULL)
    {
        return -1;
    }
    else
    {
        return elements[h]->value;
    }
}

void HashTable::remove(int key) {
    int h = hashFunc(key);
    int counter = 0;
    while (elements[h] != NULL && elements[h]->key != key && counter < capacity) {
        h = (h + 1) % capacity;
        counter++;
    }
    delete elements[h];
    elements[h] = NULL;
    currSize--;
}

HashTable::~HashTable() {
    clear();
    delete[] elements;
}

int main() {
    HashTable* ht = new HashTable(10);
    ht->insert(114142333, 69);
    ht->insert(114141333, 70);
    ht->insert(214141333, 1);
    ht->insert(314141133, 2);
    ht->insert(141414133, 3);
    ht->insert(514145333, 4);
    ht->insert(144141433, 5);
    ht->insert(314141443, 6);
    ht->insert(714141413, 7);
    ht->insert(1141414144, 8);

    printf("%d\n", ht->lookup(1141414144));
    printf("%d\n", ht->get(1141414144));
}