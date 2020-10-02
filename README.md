# Wallet 

Create a User Wallet system where a user can come and register for a wallet. User will be able to make transactions using wallet Write APIs for
  
   1) Create a User Account - Sign-in/Sign-up
   2) Add Money To Wallet
   3) Transferring money from one wallet to another
   4) Compute charges and commission 
   5) Do status inquiry of a transaction
   6) Reversal of a transaction
   7) View Passbook - All Transactions with all legs of a transaction of the user


Note: Both charge and commission can be applicable to either DEBIT or CREDIT party based on the input. 
Charge - 0.2% of the Transaction Amount
Commission - 0.05% of the Transaction Amount

Use in memory database or RDBMS (like MySQL) as convenient.

## Tech Stack
-Java
-Spring Boot
-Jpa
-Sql

Registration:

http://localhost:8080/registration

**Sample Request Response**

```
{
    "firstName": "Ck",
    "lastName": "Khamari",
     "phoneNumber": "9900065442",
    "emailid": "chandrakant.kh13@gmail.com",
    "password": "abcde"
   
}
```

Response:

```
{
    "Registration Info": [
        {
            "Status": "Success",
            "Status Message": "Registration Successfull",
            "PhoneNumber": "9900065442"
        }
    ]
}

```
 

Login:
http://localhost:8080/login

```
{
   
     "phoneNumber": "9900065441",
    "password": "abcde"
   
}

```

Response:

```
{
    "User Info": [
        {
            "Status": "Successfully Login",
            "Balance Amount": 0.00,
            "PhoneNumber": "9900065441"
        }
    ]
}

```

With Invalid Password:

```
{
   
     "phoneNumber": "9900065441",
    "password": "abcdy"
   
}
```
Response:

```
{
    "Registration Info": [
        {
            "Status Message": "Invalid credential, Kindly provide Correct password",
            "PhoneNumber": "9900065441",
            "Password": "abcdy"
        }
    ]
}

```

Without Registration:

```
{
   
     "phoneNumber": "9900065448",
    "password": "abcdy"
   
}
```
Response:

```
{
    "Registration Info": [
        {
            "Status Message": "Registration Required",
            "PhoneNumber": "9900065448",
            "Password": "abcdy"
        }
    ]
}

```
Add Money:
http://localhost:8080/addMoney

```
{
   
   "phoneNumber": "9900065441",
   "amount": 30
   
}
```

Response:

```
{
    "Money Add": [
        {
            "Status": "Money has been added successfully",
            "Amount": 30,
            "phoneNumber ": "9900065441",
            "transactionId": "f69bb01e-0748-42ea-b24c-05a0ad5fb027"
        }
    ]
}
```
TransferMoney:
http://localhost:8080/transferMoney

```
{
   
     "phoneNumberFrom": "9900065441",
     "amount": 30,
    "phoneNumberTO": "9900065442"
   
}
```
Response:

```
{
    "Transaction": [
        {
            "Status": "Success",
            "Amount": "30",
            "From": "9900065441",
            "To": "9900065442",
            "Transactionid": "a6126269-d15e-4958-8454-de16294d6553"
        }
    ]
}
```
viewPassbook: GET

http://localhost:8080/viewPassbook/9900065441
Response:

```

{
    "Transaction": [
        {
            "Status": "Success",
            "Commision": 0.15,
            "TransactionType": "Credit",
            "Amount": 29.40,
            "Charge": 0.60,
            "Transactionid": "c510da31-3bc4-4672-9dde-1044ec046531",
            "TransactionDate": "2020-10-02T22:16:40.076+00:00"
        },
        {
            "Status": "Success",
            "Commision": 0.15,
            "TransactionType": "Credit",
            "Amount": 29.40,
            "Charge": 0.60,
            "Transactionid": "a44fc08e-e2f1-4c38-8317-2aae1c20a8da",
            "TransactionDate": "2020-10-02T22:16:40.877+00:00"
        },
        {
            "Status": "Success",
            "Commision": 0.15,
            "TransactionType": "Credit",
            "Amount": 29.40,
            "Charge": 0.60,
            "Transactionid": "9a1b59d1-3df1-4844-9eb0-13e29ea516f6",
            "TransactionDate": "2020-10-02T22:16:41.464+00:00"
        },
        {
            "Status": "Success",
            "Commision": 0.30,
            "TransactionType": "Debit",
            "Amount": 58.80,
            "Charge": 1.20,
            "Transactionid": "ceda31ab-6585-4ce9-824e-8c08c4edf20f",
            "TransactionDate": "2020-10-02T22:16:54.732+00:00"
        }
    ]
}

```
Transaction Status: (Get)
http://localhost:8080/transactionStatus/9a1b59d1-3df1-4844-9eb0-13e29ea516f6
Response:

```
{
    "Transaction": [
        {
            "Status": "Success",
            "Amount": 29.40,
            "Transaction Type": "Credit",
            "Transaction Date": "2020-10-02T22:16:41.464+00:00",
            "Transaction id": "9a1b59d1-3df1-4844-9eb0-13e29ea516f6"
        }
    ]
}
```
Reversal Transaction:
http://localhost:8080/reversalTransaction/9a1b59d1-3df1-4844-9eb0-13e29ea516f6
Response:

```

{
    "Transaction Info": [
        {
            "Status": "No Reversal Required",
            "transactionId": "9a1b59d1-3df1-4844-9eb0-13e29ea516f6"
        }
    ]
}

```


