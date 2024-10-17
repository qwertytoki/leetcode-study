class RateLimiter{
    private final int maxRequests;
    private final long windowTimeMillis;
    private final Queue<Long> requestsInWindow;

    public RateLimiter(int maxRequests, long windowTimeMillis){
        this.maxRequests = maxRequests;
        this.windowTimeMillis = windowTimeMillis;
        this.requestsInWindow = new LinkedList<>();
    }

    public boolean allowRequest(){
        long currentTime = System.currentTimeMillis();
        while(!requestsInWindow.isEmpty() && (currentTime - requestsInWindow.peek()) > windowTimeMillis){
            requestsInWindow.poll();
        }
        if(requestsInWindow.size() < maxRequests){
            requestsInWindow.add(currentTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        RateLimiter rateLimiter = new RateLimiter(3,1000);
        for(int i =0; i< 30; i++){
            if(rateLimiter.allowRequest()){
                System.out.println("request is allowed :"+ i);
            }else{
                System.out.println("request is denied :"+ i);
            }
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }  
    }
}