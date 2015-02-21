<gvisualization:pieCoreChart elementId="piechart" title="Gender Chart" width="${450}" height="${300}" columns="${genderChartColumns}" data="${genderChartData}" />
<div id="piechart"></div>

<gvisualization:barCoreChart elementId="barchart" title="Salary Chart" width="${400}" height="${240}" vAxis="${[title: 'Yearly Salary', titleColor: 'red']}" columns="${salaryChartColumns}" data="${salaryChartData}" />
<div id="barchart"></div>

<gvisualization:geoChart elementId="geochart" width="${556}" height="${347}" columns="${countryChartColumns}" data="${countryChartData}" />
<div id="geochart"></div>


