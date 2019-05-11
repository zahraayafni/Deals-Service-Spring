# Deals-Service-Spring
A repository for Framework Programming Final Project

## API Information

| Endpoint  | Method | Function |
| ------------- | ------------- | ------------- |
| /deals | GET | Show all deals |
| /deals/active | GET | Show all active deals |
| /deals/exp | GET | Show all expired deals |
| /deals/{r_id} | GET | Show all deals by restaurant id |
| /deals/{r_id}/active | GET | Show all active deals by restaurant id |
| /deals/{r_id}/exp | GET  | Show all expired deals by restaurant id |
| /deals/{r_id} | POST  | Create deals |
| /deals/{r_id}/{id} | GET | Show deals by id for a restaurant |
| /deals/{r_id}/{id} | PUT | Update a deals by id for a restaurant |
| /deals/{r_id}/{id} | DELETE | Delete a deals by id for a restaurant |
| /deals/use/{u_id}/{r_id}/{id} | POST | Check for voucher permission |
| /deals/{u_id}/{r_id}/{id} | POST | Use voucher by a user |
| /deals/{u_id} | GET | Show voucher history of a user |