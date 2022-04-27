# Chart Component (MVC Architecture)

Welcome to my Chart Component!!

The Web Application uses a simple MVC architecture to render Charts using ***Chart JS*** and a postgres database to get required data for the chart.
The application accepts configuration files under webapp/resources to get the user configurations.

##Workflow
The app consists of a Controller which uses data provided by the Configuration files to query the database and get the required data.
The type of chart to be constructed is also given by the user and the Controller returns data based on the type of chart.
  
The Charts are divided into 4 types:
-Single Level
-Multi Level
-Two Axis Charts
-Three Axis Charts
  
The result to the client is constructed with respect to data models provided and is returned.

Configuration files serves as the root of the construction of the Chart.
  
    
The config files has the following fields: (Schema)
  
###Single Level
```
{"type":"Type of Chart Name" ,
"query":"The Query Here",
"label_marker":"The column in table to be taken as label's column here",
"column_schema":[
    {"alias":"Name of the table column from query result","display_name":"The name to be displayed on the chart","type":"Data type of column"},
    {"alias":"","display_name":"","type":""}
      //Only two fields is allowed!
    ],
    "column_display_labels":["Name of chart x axis","Name of chart y axis"]
}
```
###Multi Level
```
{"type":"Type of Chart Name" ,
"query":"The Query Here",
"label_marker":"The column in table to be taken as label's column here",
"column_schema":[
   {"alias":"Name of the table column from query result","display_name":"The name to be displayed on the chart","type":"Data type of column"},
   {"alias":"","display_name":"","type":""}
   {"alias":"","display_name":"","type":""}
   {"alias":"","display_name":"","type":""}
     //Any Number of fields allowed
    ],
"column_display_labels":["Name of chart x axis","Name of chart y axis"]
}
```
###Two Axis Charts
```
  {"type":"Type of Chart Name",
    "query":"The Query Here",
    "label_marker":"The column in table to be taken as label's column here",
    "x_plot_columns":[List of columns to be considered as x plots in table],
    "y_plot_columns":[List of columns to be considered as y plots in table],
    "plot_labels":[List of the names of plots],
    "column_display_labels":["Name of chart x axis","Name of chart y axis"]
    }
```
###Three Axis Charts
```
  {"type":"Type of Chart Name",
    "query":"The Query Here",
    "label_marker":"The column in table to be taken as label's column here",
    "x_plot_columns":[List of columns to be considered as x plots in table],
    "y_plot_columns":[List of columns to be considered as y plots in table],
    "z_plot_columns":[List of columns to be considered as y plots in table],
    "plot_labels":[List of the names of plots],
    "column_display_labels":["Name of chart x axis","Name of chart y axis"]
    }
```
The config files are of type JSON and is required to have the specified as given below.
  
The Names of Configuration files are required to be as follows:
-Single Level
 -bar 
 -pie
 -line
 -doughnut
 -polar
 -exploded
 -histogram  
-Multi Level
 -nestedDoughnut
 -stackedBar
 -groupedBar
 -multiLine
 -radar
-Two Axis Charts
 -scatter
 -Three Axis Charts
 -bubble
