
// Written by
// Arsyi Syarief Aziz
// H071191003

struct HashEntry {
    HashEntry(int key, int value);
    int key;
    int value;
};

class HashTable {
public:
    HashTable(int capacity);
    ~HashTable();
    void insert(int key, int value);
    void clear();
    bool lookup(int key) const;
    void remove(int key);
    int hashFunc(int key) const;
    int get(int key) const;

private:
    HashEntry** elements;
    int capacity;
    int currSize;
};