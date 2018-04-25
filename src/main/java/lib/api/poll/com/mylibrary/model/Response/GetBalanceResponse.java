package lib.api.poll.com.mylibrary.model.Response;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class GetBalanceResponse
{
    private int status = 0;
    private String message , dateCreated , balanceAmount , creditBalance , pollBalance , nextBillingDay , lastpaymentDate, membersince;

    public GetBalanceResponse(String message)
    {
        this.message = message;
    }
    public GetBalanceResponse(String balanceAmount , String creditBalance, String pollBalance)
    {
        this.balanceAmount = balanceAmount;
        this.creditBalance = creditBalance ;
        this.pollBalance = pollBalance;
        this.status = 1;
    }

    /*
    {
  "userId": "070f4091-0ac7-4efe-bc93-f0eecc4da8c4",
  "dateCreated": "2018-04-25T02:16:27.2947191-07:00",
  "balanceAmount": 1.0,
  "modifiedDate": "2018-04-25T02:16:27.2947191-07:00",
  "creditBalance": 1,
  "pollsBalance": 1,
  "nextBillingDay": 1,
  "lastPaymentDate": "2018-04-25T02:16:27.2947191-07:00",
  "memberSince": "2018-04-25T02:16:27.2947191-07:00"
}
     */
}
