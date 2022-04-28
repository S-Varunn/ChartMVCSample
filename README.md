# Chart Component (MVC Architecture)

Welcome to my Chart Component!!

The Web Application uses a simple MVC architecture to render Charts using ***Chart JS*** and a postgres database to get required data for the chart.
The application accepts configuration files under webapp/resources to get the user configurations.

# Workflow

The app consists of a Controller which uses data provided by the Configuration files to query the database and get the required data.
The type of chart to be constructed is also given by the user and the Controller returns data based on the type of chart.
  
The Charts are divided into 3 types:
* Single Level / Multi Level
* Two Axis Charts
* Three Axis Charts
* Tree Charts
  
The result to the client is constructed with respect to data models provided and is returned.

Configuration files serves as the root of the construction of the Chart.
  
    
The config files has the following fields: (Schema)
  
### Single/Multi Level Charts

```
{"type":"Type of Chart Name" ,
"query":"The Query Here",
"label_marker":"The column in table to be taken as label's column here",
"column_schema":[
    {"alias":"Name of the table column from query result","display_name":"The name to be displayed on the chart",
    "type":"Data type of column","backgroundColor":"Background Colour of chart -- Single or List of colours"},
    {"alias":"","display_name":"","type":"","backgroundColor": ' "" or [] ' }
    ],
    "column_display_labels":["Name of chart x axis","Name of chart y axis"]
}
```

### Two Axis Charts

```
  { "type":"Type of Chart Name",
    "query":"The Query Here",
    "label_marker":"The column in table to be taken as label's column here",
    "x_plot_columns":[List of columns to be considered as x plots in table],
    "y_plot_columns":[List of columns to be considered as y plots in table],
    "plot_labels":[List of the names of plots],
    "column_display_labels":["Name of chart x axis","Name of chart y axis"]
    }
```
### Three Axis Charts

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

### Tree Charts 

```
Coming soon!
```

The config files are of type JSON and is required to have the specified as given below.
  
The Names of Configuration files are required to be as follows:

***Single Level / Multi Level***
 - bar 
 - pie
 - line
 - doughnut
 - polar
 - exploded
 - histogram
 - nestedDoughnut
 - stackedBar
 - groupedBar
 - multiLine
 - radar 

***Two Axis Charts***
 - scatter

***Three Axis Charts***
 - bubble

***Tree Charts***
 - Coming Soon!

# Response Data Format

### Single Variable DataSet
``` 
data = {
  labels: ["Jan","Feb","Mar","Apr","May"] , //List of label data
  datasets: [
    {
      name: "Marketing Team Profits", //Name of dataset
      data: ["100000","120000","125000","120000","150000"], //List of data corresponding to label
      ...payload
    },
    {
      name: "Sales Team Profits", //Name of dataset
      data: ["200000","220000","225000","220000","250000"], //List of data corresponding to label
      ...payload
    }
  ]
};

payload options: {
  backGroundColour: "blue" / ["blue","green","yellow","green","red"], //Single background colour or List of colours representing each bar
  typeOfChart: "bar" // the type of chart the data belongs to
}
```

### Multi Variable DataSet

```
data = [
        {
          label: "Sample A", // Name of dataset 1
          data: [{
            x: 'Value',
            y: 'Value',
            r: 'Value'
          },{
            x: 'Value',
            y: 'Value',
            r: 'Value'
          }
          ],
         ...payload 
        }, {
         label: "Sample B", // Name of dataset 2
          data: [{
            x: 'Value',
            y: 'Value',
            r: 'Value'
          },{
            x: 'Value',
            y: 'Value',
            r: 'Value'
          }
          ],
         ...payload 
        }
      ]
      
payload options: {
  backGroundColour: "blue", // single background colour
  typeOfChart: "bubble" // the type of chart the data belongs to
}
```
### Tree DataSet

```
data: [
        {
            "label": "Products", \\Name of dataset
            "value": "150", //value of the data
            ...payload
            "data": [
                {
                    "label": "Food & Beverages", \\Name of dataset
                    "value": "80",
                    "data": [
                        {
                            "label": "Ramen", \\Name of dataset
                            "value": "30",
                            ...payload
                        },
                        {
                            "label": "Meat", \\Name of dataset
                            "value": "50",
                            ...payload
                        }
                     ],
                     ...payload
                },
                {
                    "label": "Drinks", \\Name of dataset
                    "value": "70",
                    "data": [
                        {
                            "label": "7-Up", \\Name of dataset
                            "value": "40",
                            ...payload
                        },
                        {
                            "label": "Mountain Dew", \\Name of dataset
                            "value": "30",
                            ...payload
                        }
                    ],
                    ...payload
                }
             ]
          }
      ]
  payload options: {
  backGroundColour: "blue", //single background colour
  typeOfChart: "multiLevelPie" // the type of chart the data belongs to
}
```
