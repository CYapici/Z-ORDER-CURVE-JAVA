

// == ZOrderCurve ==
// Copyright(c) Cagatay Yapici, 2015  
// cagatayyapici@windowslive.com
 
Z ORDER CURVE AKA MORTON ORDER IMPLEMENTATION IN JAVA 
Bit operations of Z Order Curve needs Uint unsigned primitive, the UINT32 class in this project is not a primitive but it synthetically

works like a primitive unsigned type. 
I did not test performance . But I saw there is not much difference than C++ when encrypting numbers smaller than 10 digits.
In million or thousands of triplets  thereshold i estimate that there will be great performance deficiency  because of the factors stated above.


Please look definitions from : 
https://en.wikipedia.org/wiki/Z-order_curve
https://en.wikipedia.org/wiki/Morton_number

----
www.cagatayyapici.com


