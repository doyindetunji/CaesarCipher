class HashTable:
    def __init__(self, size):
        #Initialize the hash table with a fixed size
        self.size = size
        self.table = [None] * size
        
    def hash(self, key):
        #Hash function to get the index of the key
        return hash(key) % self.size
    
    def insert(self, key, value):
        #Insert a key-value pair into the hash table
        index = self.hash(key)
        if self.table[index] is not None:
            self.table[index] = [(key, value)]
        else:
            for pair in self.table[index]:
                if pair[0] == key:
                    #update the value of the existing key
                    pair = (key, value)
                    return
                #handling collision using chaining
                self.table[index].append((key, value))
                
    def search(self, key):
        #Search for a key in the hash table
        index = self.hash(key)
        if self.table[index] is not None:
            for pair in self.table[index]:
                if pair[0] == key:
                    return pair[1]
                #if key is not found
        return None
    
    def delete(self, key):
        #delete a key-value pair from the hash table
        index = self.hash(key)
        if self.table[index] is not None:
            for i, pair in enumerate(self.table[index]):
                if pair[0] == key:
                    self.table[index].pop(i)
                    return