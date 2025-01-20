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