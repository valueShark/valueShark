let companySymbolsArray = [[${message}]];

$( function() {
    var availableTags = [
      "Apple",
      "Facebook",
      "Tesla",
      "Bank Of America",
      "Teva",
      "WeWork",
      "SpaceX",
      "Blue Origin",
      "Amazon",
      "CodeFellows",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#symbol" ).autocomplete({
      source: availableTags
    });
  } );

