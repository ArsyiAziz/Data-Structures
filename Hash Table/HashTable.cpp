
// Written by
// Arsyi Syarief Aziz
// H071191003

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

    if (elements[h] == NULL || counter == capacity) {
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
    while (elements[h] != NULL && elements[h]->key != key && counter < capacity) {
        h = (h + 1) % capacity;
        counter++;
    }

    if (elements[h] == NULL || counter == capacity) {
        return -1;
    }
    else {
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
    if (counter == capacity) {
        return;
    }
    delete elements[h];
    elements[h] = NULL;
    currSize--;
}

HashTable::~HashTable() {
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

    int keyToBeLookedUp = 144141433;
    printf("Does the key %d exist in the hash table? ", keyToBeLookedUp);
    printf("%d\n", ht->lookup(keyToBeLookedUp));

    printf("The value of key %d is... ", keyToBeLookedUp);
    printf("%d\n\n", ht->get(keyToBeLookedUp));

    int keyToBeLookedUp2 = 214141333;
    printf("Does the key %d exist in the hash table? ", keyToBeLookedUp2);
    printf("%d\n", ht->lookup(keyToBeLookedUp2));

    printf("The value of key %d is... ", keyToBeLookedUp2);
    printf("%d\n\n", ht->get(keyToBeLookedUp2));

    int keyToBeDeleted = 1141414144;
    printf("Deleting the key %d\n", keyToBeDeleted);
    ht->remove(keyToBeDeleted);

    printf("Does the key %d exist in the hash table? ", keyToBeDeleted);
    printf("%d\n", ht->lookup(keyToBeDeleted));

    printf("The value of key %d is... ", keyToBeDeleted);
    printf("%d\n", ht->get(keyToBeDeleted));
}

