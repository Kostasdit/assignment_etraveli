# assignment_etraveli


The project was done using springboot,maven,java,testNG,lombok,selenium and as idle Intellij
The project was tested on Google chrome version 106.0.5249.119 (64-bit)
In order to run the test please go to configuration and select maven with clean test options.

The project has only one test with multiple test steps.
In every test step , there is a description to understand what exactly each step verifies.
In this specific case i created the test having in mind that this is a regression test , so i only added positive cases(happy path) to verify the filters.
I check each filter individually but of course you can create more complex cases using the existing code.

Important Notes:
The code can only add adults as passenger and verify the steps using the results of the filter(a string in the right up corner)
As tested data i have the UI(manual test) but it was impossible to find the exact data because in every run with the same criteria the number of flights were different.
In my opinion, the expected data should be retrived from the API(post) and not from the UI.
You can desirialize these data to an object and use it to test your expected.

Bugs:
I didnt find any important bugs.
1)in the clear all filter in the airlines,the number of flights that should be returned is zero because you diselect everything.
2)A small UI bug. When search with some filters(eg.no number of stops) there was a second : in the return.
For example  Filter by : : 87 of 977 flights


