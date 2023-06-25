# Railway-TimeTable
## Introduction
This repository contains a Java console-based software solution for a railway timetable system. The software provides functionalities such as timetable data persistence, timetable view, origin/destination filtering, station code interchangeability, journey duration calculation, station facility display & filtering, and real-time live departure boards (LDBs).

## Features
### A. Timetable Data Persistence
The timetable data is read from a file. The data includes information about the routes, stations, and times.

### B. Matrix or Tabular View
The application displays a timetable of services in a tabular format for a given route. The layout includes columns for the time of day and rows for stations/stops. The view allows scrolling through times and stations.

### C. Origin/Destination Filtering
The tabular view can be filtered to show only rows for a specified origin and destination station. It filters out services that do not call at both origin and destination stations.

### D. Interchangeable Station Codes
The system accepts either 3-letter "CRS" station codes or the full station name as input. The mappings are not hardcoded and are drawn from a station codes document at start-up.

### E. Journey Duration Calculation
The software calculates and displays the journey time, in hours and minutes, for a filtered timetable. For an unfiltered timetable, the total (end-to-end) journey time is displayed.

### F. Station Facility Display & Filtering
The software can filter stations in the tabular view based on whether it has car parking, bicycle racks/storage, and step-free access/disability assistance. In unfiltered mode, the view indicates whether a station has these facilities.

### G. Real-Time LDBs (Live Departure Boards)
The software presents a Live Departure Board for the selected departure station, showing only those services calling at the desired destination station. The results show the high-level details of any matching service.

### H. Enhanced LDB
The software allows the user to select any service shown in the LDB feature and show more details for this service. This includes calling points and calling times for each service, train length, and delay or cancellation reason.

### Usage
To run the software, you need to have Java installed on your machine. Clone the repository, navigate to the directory containing the .java files, and run the main file.

### Contribution
Contributions to this project are welcome. If you find any errors or have suggestions for improvements, please open an issue or submit a pull request.

### License
This project is licensed under the terms of the MIT license
