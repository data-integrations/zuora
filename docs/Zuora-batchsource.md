# Zuora batch source

Description
-----------
Plugin fetches data from Zuora. Zuora is a subscription management platform designed to meet your
modern order-to-cash needs.
 
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

**Base Objects:** List of available objects to fetch

Available:
- Products
- Refunds
- PaymentRun
- Orders
- Entities
- DebitMemos
- CreditMemos
- BillingDocuments








