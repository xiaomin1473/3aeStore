mermaid.initialize({
      theme: 'forest',
      // themeCSS: '.node rect { fill: red; }',
      logLevel: 3,
      flowchart: { curve: 'linear' },
      gantt: { axisFormat: '%m/%d/%Y' },
      sequence: { actorMargin: 50 },
      // sequenceDiagram: { actorMargin: 300 } // deprecated
    });

 function testClick(nodeId) {
	  console.log("clicked", nodeId)
	  var originalBgColor = document.querySelector('body').style.backgroundColor
	  document.querySelector('body').style.backgroundColor = 'yellow'
	  setTimeout(function() {
		document.querySelector('body').style.backgroundColor = originalBgColor
	  }, 100)
}