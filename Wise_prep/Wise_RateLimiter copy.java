public class RateLimiter{
    private final int maxRequests;
    private final long timeWindowMillis;
    private final Queue<Long> requestTimestamps;
    
    public RateLimiter(int maxRequests, long timeWindowMillis){
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
        this.requestTimestamps = new LinkedList<>();
    }
    
    public synchronized boolean allowRequest(){
        long currentTime = System.currentTimeMillis();
        while(!requestTimestamps.isEmpty() && (currentTime - requestTimestamps.peek())> timeWindowMillis){
            requestTimestamps.poll();
        }
        if(requestTimestamps.size() < maxRequests){
            requestTimestamps.add(currentTime);
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        RateLimiter rateLimiter = new RateLimiter(3,1000);
        for(int i= 0; i<30; i++){
            if(rateLimiter.allowRequest()){
                System.out.println("Request allowed :" + i);
            }else{
                System.out.println("Request denied :" + i);
            }
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
}