INSERT  INTO
	work_interview
      ( 
      ID                            
      ,APPLY_ID                       
      ,GUIDE_ID                       
      ,MANAGEMENT                     
      ,INTERVIEW_STATUS               
      ,INTERVIEW_DATE                 
      ,CHOOS_TIME                     
      ,DEAL_DATE                      
      ,DEAL_PERSION                   
      ,AUDIT                          
      ,REPLY                          
      ) 
values
      (
      :workInterview.id                            
      ,:workInterview.applyId                       
      ,:workInterview.guideId                       
      ,:workInterview.management                    
      ,:workInterview.interviewStatus               
      ,:workInterview.interviewDate                 
      ,:workInterview.choosTime                     
      ,:workInterview.dealDate                      
      ,:workInterview.dealPersion                   
      ,:workInterview.audit                         
      ,:workInterview.reply                         
      )