@poll
Feature: Poll verification

  @poll1
  Scenario: User can selected an answer
    Given I go to  "nextBaseCRM" page
    Then I logIn as "marketing" user
    And I create a poll
    Then I select the first answer
    And I verify that first answer should be selected














#1. users  (hr, marketing and helpdesk)  can select an answer to vote a poll.
#(this scenario has a pre-condition: at least one poll should be created)
#2. users can use "vote agian" botton to slect different answer
#3. only vote owner stop the poll with "STOP" button
#(no negative scenario for this functionality because otehr non owner user cannot see stop button)