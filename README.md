# Railway-TimeTable

Analysed,  designed  and  implemented  a  Java,  console-based  software  solution  that 
addresses some or all of the following functional points. They are categorised according to difficulty:

A. Timetable Data Persistence: The timetable data (you must determine exact requirements through this 
specification and subject research) should be read from (a) file(s). There is no requirement that this data is 
editable;  you  can  either  populate  a  test  file  yourself  by  hand  (e.g.  from  included  example  PDFs  or  similar 
alternatives), or attempt to interpret any available rail timetable data your research uncovers. 
 
 
B. Matrix or Tabular View: The application must be able to display, 
for  a  given  route,  a  timetable  of  services  in  a  tabular  format.  The 
usual  layout  is  columns  show  the  time  of  day,  and  rows  indicate 
stations  /  stops;  (e.g.  timetable  on  Liverpool-Blackpool  route  from 
Northern PDF) 
An  entire  timetable  will  not  fit  on  the  screen,  so  there  must  be  a 
feature to scroll forward and back through times, and up and down 
through  stations,  as  required.  There  is  no  requirement  to  include 
multiple  routes,  but  you  must  be  able  to  show  the  variations  of 
timetable  for  a  given  route  (e.g.  Mon-Fri,  Sat,  Sun  or  similar,  as 
appropriate). The requirement is that this view must show stations 
(full names) and times (where both arrival and departure times are listed, 
only the departure time need be shown)


C. Origin/Destination filtering: The tabular view should have an additional feature such that it is possible 
to filter the timetable such that it shows only rows for a specified origin and destination station. This must 
filter out services that do not call at BOTH origin and destination stations (e.g. expresses). 
 

D. Interchangeable station codes: All input facilities function with either 3-letter “CRS” station codes or 
the full station name (e.g. LIV = Liverpool Lime St) – i.e. typing LIV should indicate to the system that Liverpool 
Lime St is the required station. The mappings must not be hardcoded; they must be drawn from a station codes 
document at start-up. It is available for download from here: https://bit.ly/4121Stations


E. Journey Duration calculation: Given the known start and end times, when a filtered timetable is shown, 
the software must calculate and display the journey time, in hours and minutes. For an unfiltered timetable, 
the total (end-to-end) journey time should be displayed. 

 
F. Station facility display & filtering: A feature to filter stations in tabular view based on whether it has the 
following facilities: car parking, bicycle racks/storage, and step-free access/disability assistance. Additionally, 
when in unfiltered mode, the view should indicate whether a station has these facilities; utilising a key such as 
STATION NAME [P, B, D] would indicate the station has all 3 facilities; STATION NAME[B, D] would indicate 
it has bicycle racks and step-free access, but does not have car parking. 


G. Real-Time LDBs (Live Departure Boards): The software should be 
able to present a Live Departure Board for the selected departure station, 
such that it shows only those services calling at the desired destination 
station. This should be implemented in a feature similar to (or an extension 
of)  that  provided  for  the  Intermediate  feature,  C.  Origin  /  Destination 
filtering.  The  results  should  show  the  high-level  details  (i.e.  scheduled  vs. 
expected departure time, status (on-time, delayed, cancelled) and platform, if 
available), of any matching service. This will require you to connect to a 
service that provides this information. Examples of the data output you might expect from such a feature can 
be seen at: https://bit.ly/trainldb & https://bit.ly/NREldb  
Obviously, you are constrained somewhat by the limitations of a console application; you must produce text-
only output – console output such as the screenshot to the right would be 
acceptable.  Please  see  the  guidance  for  this  and  the  following  feature  for  some 
guidance on how this data should be acquired. 
 
H. Enhanced LDB: The software should allow the user to select any service shown in the LDB feature above, 
and show more details for this service. This should include, but is not limited to: 
• Calling points (and calling times) for each service 
• Train length (where available) / other service-specific data 
• Delay or cancellation reason (where applicable) 
