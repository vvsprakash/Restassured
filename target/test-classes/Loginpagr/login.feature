Feature: Verify  Booking Hotel in adactin

  @reg
  Scenario Outline: Booking Hotel by Select all fields
    Given User is on the  Adactin login page
    When User should enters login Details "<username>","<password>"
    And User should verify "Hello VVSURYAPRAKASH!"
    And User should  Search Hotel "<Location>","<Hotels >","<RoomType>","<CheckinDate>","<CheckoutDate>", "<NumberofRooms>","<AdultsperRoom>","<ChildrenperRoom>"
    And User should verify "Book A Hotel" is present
    And User should verify book hotel "<Firstname>","<Lastname>","<Address>" and payment
      | CreditNumber     | CreditCardType | ExpierdMonth | ExpierdYear | CVVNmuber |
      | 7896456789456123 | Visa           | December     |        2022 |       456 |
    Then User should verify confirmation "Booking Confirmation"

    Examples: 
      | username       | password   | Location | Hotels      | RoomType | NumberofRooms | CheckinDate | CheckoutDate | AdultsperRoom | ChildrenperRoom | FirstName | LastName | BillingAddress |
      | VVSuryaPrakash | Surya4118$ | Sydney   | Hotel Creek | Standard | 2 - Two       | 27/05/2022  | 30/06/2022   | 3 - Three     | 1 - One         | VVS       | Prakash  | Visakhapatnam  |

  @smoke
  Scenario Outline: Booking Hotel without entering any fields
    Given User is on the  Adactin login page
    When User should enters login Details "<username>","<password>"
    And User should verify "Hello VVSURYAPRAKASH!"
    And User should  Search Hotel "<Location>","<Hotels >","<RoomType>","<CheckinDate>","<CheckoutDate>", "<NumberofRooms>","<AdultsperRoom>","<ChildrenperRoom>"
    And User should verify "Book A Hotel" is present
    Then User should verify "Please Enter your First Name","Please Enter you Last Name" ,"Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type", " Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username       | password   | Location | Hotels      | RoomType | NumberofRooms | CheckinDate | CheckoutDate | AdultsperRoom | ChildrenperRoom |
      | VVSuryaPrakash | Surya4118$ | Sydney   | Hotel Creek | Standard | 2 - Two       | 27/05/2022  | 30/06/2022   | 3 - Three     | 1 - One         |
