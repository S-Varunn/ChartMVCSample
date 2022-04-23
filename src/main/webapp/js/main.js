window.onload = function () {
  let populateDiv = document.getElementById("populate");
  document.getElementById("bar").addEventListener("click", function () {
    let request = new XMLHttpRequest();
    request.open("GET", "http://localhost:8040/ChartMVC/MyChart?name=bar");

    request.onload = function () {
      //   const htm = document.createElement(div);
      //   let myhtml = `<canvas id="myChart" style="width: 100%; max-width: 700px"> </canvas>`;
      //   const node = document.createElement("canvas");

      console.log(request.responseText);
      let myBarData = JSON.parse(request.responseText);
      //   const xValues = JSON.stringify(myBarData.xvalues).split(",");
      //   const yValues = JSON.stringify(myBarData.yvalues).split(",");
      //   let barColors = myBarData.barColours;
      //   let resultarrx = [];
      //   let resultarry = [];
      //   for (let i in xValues) {
      //     resultarrx.push(xValues[i]);
      //   }
      //   for (let i in yValues) {
      //     resultarry.push(yValues[i]);
      //   }

      var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];
      var yValues = [55, 49, 44, 24, 15];
      var barColors = ["red", "green", "blue", "orange", "brown"];

      new Chart("myChart", {
        type: "bar",
        data: {
          labels: xValues,
          datasets: [
            {
              backgroundColor: barColors,
              data: yValues,
            },
          ],
        },
        options: {
          legend: { display: false },
          title: {
            display: true,
            text: "First Chart",
          },
        },
      });
    };
    // populateDiv.appendChild(node);
    request.send();
  });
  document.getElementById("stacked-bar").addEventListener("click", function () {
    location.href = "http://localhost:8040/ChartMVC/MyChart?name=stackedbar";
  });
  document.getElementById("grouped-bar").addEventListener("click", function () {
    location.href =
      "http://localhost:8040/ChartMVC/MyChart?name=groupedbarchart";
  });
};
