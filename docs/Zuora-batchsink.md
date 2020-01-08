# Zuora Batch Sink


Description
-----------
Writes records to a Zuora objects. Each record will be written to an object collection.


Use Case
--------
This sink is used whenever you need to write a Zuora objects.


Properties
----------
### General

**Reference Name:** Name used to uniquely identify this source for lineage, annotating metadata, etc.

**Authentication type:** way, how user would like to be authenticated to the Zuora account

**Basic:**

- ***Username:*** Login name for the Zuora account
- ***Password:*** Password for the Zuora account

**OAuth2:**
- ***Client ID:*** The OAuth2 client id 
- ***Client SecretD:*** The OAuth2 client secret 

**Body column name:** column name which would contains the JSON content to post

**Object to write to:** List of available objects to fetch.

Available objects: 
- BillingDocumentFilesDeletionJobResponse
- CreditMemo
- CreditMemoAmountBreakdownByOrder
- DebitMemo
- GenerateBillingDocument
- InvoiceAmountBreakdownByOrder
- Payments
- PaymentRun
- PostOrder
- PostOrderPreview
- RefundCreditMemo
- RefundPayment
- Taxation

**Request arguments source:**  place to read the arguments, could be used configuration or Input Record.

**Request arguments:** required arguments for the objects

    +---------------------------+-------------------------+
    |     Request argument      |   Applicable object     |
    +---------------------------+-------------------------+
    | invoiceId                 | DebitMemo, CreditMemo   |
    | id                        | GenerateBillingDocument |
    | creditmemoId              | RefundCreditMemo        |
    | paymentId                 | RefundPayment           |
    | debitMemoId               | Taxation                |
    +---------------------------+-------------------------+
