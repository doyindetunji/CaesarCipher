def decrypt(ciphertext, shift):
    plaintext = ""
    for char in ciphertext:
        if char.isalpha():
            shift_amount = 65 if char.isupper() else 97
            plaintext += chr((ord(char) - shift_amount - shift) % 26 + shift_amount)
        else:
            plaintext += char
        return plaintext
    
def brute_force(ciphertext):
    for shift in range(26):
        plaintext = decrypt(ciphertext, shift)
        print(f"Shift {shift}: {plaintext}")
        
ciphertext = "CGRRC YQ YZGE"
brute_force(ciphertext)