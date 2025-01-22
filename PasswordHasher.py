import hashlib

def hashPassword(password):
    return hashlib.sha256(password.encode()).hexdigest()

password = input("Enter your password: ")
hashPassword = hashPassword(password)
print(f"Hashed password: {hashPassword}")