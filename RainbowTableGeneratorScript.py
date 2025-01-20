import hashlib
import csv

#Top 10 lists of common passwords in 2024 according to Nordpass
passwords = ["123456", "123456789", "12345678", "password", "qwerty123", "qwerty1", "111111", "12345", "secret", "123123"]

#Function to create md5 hash
def md5sum(password):
    return hashlib.md5(password.encode()).hexdigest()

#function to create sha256 hash
def sha256sum(password):
    return hashlib.sha256(password.encode()).hexdigest()

#file to save the results
OutputFile = "RainbowTable.csv"

#Write the result in the csv file
with open(OutputFile, mode='w', newline='') as file:
    writer = csv.writer(file)
    #Write thee header
    writer.writerow(["Password", "MD5 HASH", "SHA-256 HASH"])
    
    #create the hashes and write each row
    for password in passwords:
        writer.writerow([password, md5sum(password), sha256sum(password)])
        
print("Rainbow Table created successfully in the file: ", OutputFile)