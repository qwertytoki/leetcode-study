class RateLimiter{
    private final int maxRequests;
    private final long windowTimestampMillis;
    private final Queue<Long> currentWindow;
    
    public RateLimiter(int maxRequests, long windowTimestampMillis){
        this.maxRequests = maxRequests;
        this.windowTimestampMillis = windowTimestampMillis;
        this.currentWindow = new LinkedList<>();
    }
    public synchronized boolean allowRequest(){
        long currentTimeMillis = System.currentTimeMillis();
        while(!currentWindow.isEmpty() && (currentTimeMillis - currentWindow.peek())> windowTimestampMillis){
            currentWindow.poll();
        }
        if(currentWindow.size() < maxRequests){
            currentWindow.add(currentTimeMillis);
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        RateLimiter rateLimiter = new RateLimiter(3, 1000);
        
        for(int i =1 ; i<= 30; i++){
            if(rateLimiter.allowRequest()){
                System.out.println("Request allowed : " + i);
            }else{
                System.out.println("Request denied : " + i);
            }
            try{
                Thread.sleep(100);    
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}