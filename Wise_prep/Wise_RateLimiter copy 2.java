public class RateLimiter{
    private Queue<Long> requestTimestamps;
    private final int maxRequests;
    private final long timeWindowMillis;
    
    public RateLimiter(int maxRequests, long timeWindowMillis){
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
        this.requestTimestamps = new LinkedList<>();
    }
    
    public boolean allowRequest(){
        long currentTime = System.currentTimeMillis();
        while(!requestTimestamps.isEmpty() 
           && (currentTime-requestTimestamps.peek()) > timeWindowMillis){
            requestTimestamps.poll();
        }
        if(requestTimestamps.size()<maxRequests){
            requestTimestamps.add(currentTime);
            return true;
        }
        return false;
        
    }
    
    public static void main(String[] args){
        RateLimiter rateLimiter = new RateLimiter(3, 1000);
        for(int i =1; i<= 30; i++){
            if(rateLimiter.allowRequest()){
                System.out.println("Request allowed : "+ i);    
            }else{
                System.out.println("Request denied : "+ i);
            }
            try{
                Thread.sleep(100);    
            }catch(Exception e){
                e.printStackTrace();
            }   
        }
    }
}