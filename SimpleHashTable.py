class HashTable:
    def __init__(self, size):
        # Initialize the hash table with a fixed size
        self.size = size
        self.table = [None] * size






"""
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
            for pair in self.table[index]:
                if pair[0] == key:
                    self.table[index].remove(pair)
                    #remove empty bucket
                    if not self.table[index]:
                        self.table[index] = None
                    return True
                #if key is not found
        return False
    
    def display(self):
        #Display the contents of the hash table
        for i, bucket in enumerate(self.table):
            if bucket:
                print(f"Index {i}: {bucket}")
            else:
                print(f"Index {i}: Empty")
                
#Example usage
if __name__ == "__main__":
    # Create a hash table of size 10
    hash = HashTable(size=10)

    # Insert key-value pairs
    hash.insert("name", "Alice")
    hash.insert("age", 25)
    hash.insert("city", "New York")

    # Display the hash table
    print("Hash Table:")
    hash.display()

    # Search for a key
    print("\nSearch for 'name':", hash.search("name"))
    print("Search for 'age':", hash.search("age"))
    print("Search for 'country':", hash.search("country"))  # Key not found

    # Delete a key
    print("\nDeleting 'city'...")
    hash.delete("city")
    
    # Display the hash table after deletion
    print("\nHash Table After Deletion:")
    hash.display()
"""