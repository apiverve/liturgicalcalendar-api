# Liturgical Calendar API - PHP Package

Liturgical Calendar is a simple tool for getting the dates of the Liturgical Calendar. It returns the dates of the Liturgical Calendar for a given year.

## Installation

Install via Composer:

```bash
composer require apiverve/liturgicalcalendar
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Liturgicalcalendar\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'month' => 2,
    'year' => 2025
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Liturgicalcalendar\Client;
use APIVerve\Liturgicalcalendar\Exceptions\APIException;
use APIVerve\Liturgicalcalendar\Exceptions\ValidationException;

try {
    $response = $client->execute(['month' => 2, 'year' => 2025]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "2025-12-01": [
      {
        "id": "advent_1_monday",
        "date": "2025-12-01",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            1,
            1
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 1,
            "dow": 1
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 2,
          "dayOfWeek": 1,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-02": [
      {
        "id": "advent_1_tuesday",
        "date": "2025-12-02",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            2,
            1
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 1,
            "dow": 2
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 3,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-03": [
      {
        "id": "francis_xavier_priest",
        "date": "2025-12-03",
        "dateDef": {
          "month": 12,
          "date": 3
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "names:francis_xavier_priest"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "None"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 4,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_1_wednesday",
          "date": "2025-12-03",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              3,
              1
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 1,
              "dow": 3
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 1,
            "dayOfSeason": 4,
            "dayOfWeek": 3,
            "nthDayOfWeekInMonth": 1,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-04": [
      {
        "id": "advent_1_thursday",
        "date": "2025-12-04",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            4,
            1
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 1,
            "dow": 4
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 5,
          "dayOfWeek": 4,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "john_damascene_priest",
        "date": "2025-12-04",
        "dateDef": {
          "month": 12,
          "date": 4
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:john_damascene_priest"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "Pastors",
          "DoctorsOfTheChurch"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 5,
          "dayOfWeek": 4,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_1_thursday",
          "date": "2025-12-04",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              4,
              1
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 1,
              "dow": 4
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 1,
            "dayOfSeason": 5,
            "dayOfWeek": 4,
            "nthDayOfWeekInMonth": 1,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-05": [
      {
        "id": "advent_1_friday",
        "date": "2025-12-05",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            5,
            1
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 1,
            "dow": 5
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 6,
          "dayOfWeek": 5,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-06": [
      {
        "id": "advent_1_saturday",
        "date": "2025-12-06",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            6,
            1
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 1,
            "dow": 6
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 7,
          "dayOfWeek": 6,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "nicholas_of_myra_bishop",
        "date": "2025-12-06",
        "dateDef": {
          "month": 12,
          "date": 6
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:nicholas_of_myra_bishop"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "Bishops"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 7,
          "dayOfWeek": 6,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_1_saturday",
          "date": "2025-12-06",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              6,
              1
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 1,
              "dow": 6
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 1,
            "dayOfSeason": 7,
            "dayOfWeek": 6,
            "nthDayOfWeekInMonth": 1,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-07": [
      {
        "id": "advent_2_sunday",
        "date": "2025-12-07",
        "dateDef": {
          "dateFn": "sundayOfAdvent",
          "dateArgs": [
            2
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_SUNDAY_2",
        "rank": "SUNDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.sunday",
          {
            "week": 2
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 8,
          "dayOfWeek": 0,
          "nthDayOfWeekInMonth": 1,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-08": [
      {
        "id": "immaculate_conception_of_the_blessed_virgin_mary",
        "date": "2025-12-08",
        "dateDef": {
          "dateFn": "immaculateConceptionOfMary"
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "GENERAL_SOLEMNITY_3",
        "rank": "SOLEMNITY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "i18nDef": [
          "names:immaculate_conception_of_the_blessed_virgin_mary"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "None"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 9,
          "dayOfWeek": 1,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-09": [
      {
        "id": "advent_2_tuesday",
        "date": "2025-12-09",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            2,
            2
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 2,
            "dow": 2
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 10,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "juan_diego_cuauhtlatoatzin",
        "date": "2025-12-09",
        "dateDef": {
          "month": 12,
          "date": 9
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:juan_diego_cuauhtlatoatzin"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "Saints"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 10,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_2_tuesday",
          "date": "2025-12-09",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              2,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 2,
              "dow": 2
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 10,
            "dayOfWeek": 2,
            "nthDayOfWeekInMonth": 2,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-10": [
      {
        "id": "advent_2_wednesday",
        "date": "2025-12-10",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            3,
            2
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 2,
            "dow": 3
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 11,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "our_lady_of_loreto",
        "date": "2025-12-10",
        "dateDef": {
          "month": 12,
          "date": 10
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:our_lady_of_loreto"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "BlessedVirginMary"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 11,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_2_wednesday",
          "date": "2025-12-10",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              3,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 2,
              "dow": 3
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 11,
            "dayOfWeek": 3,
            "nthDayOfWeekInMonth": 2,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-11": [
      {
        "id": "advent_2_thursday",
        "date": "2025-12-11",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            4,
            2
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 2,
            "dow": 4
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 12,
          "dayOfWeek": 4,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "damasus_i_pope",
        "date": "2025-12-11",
        "dateDef": {
          "month": 12,
          "date": 11
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:damasus_i_pope"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "PopeOrBishop"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 12,
          "dayOfWeek": 4,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_2_thursday",
          "date": "2025-12-11",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              4,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 2,
              "dow": 4
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 12,
            "dayOfWeek": 4,
            "nthDayOfWeekInMonth": 2,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-12": [
      {
        "id": "advent_2_friday",
        "date": "2025-12-12",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            5,
            2
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 2,
            "dow": 5
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 13,
          "dayOfWeek": 5,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "our_lady_of_guadalupe",
        "date": "2025-12-12",
        "dateDef": {
          "month": 12,
          "date": 12
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:our_lady_of_guadalupe"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "BlessedVirginMary"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 13,
          "dayOfWeek": 5,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_2_friday",
          "date": "2025-12-12",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              5,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 2,
              "dow": 5
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 13,
            "dayOfWeek": 5,
            "nthDayOfWeekInMonth": 2,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-13": [
      {
        "id": "lucy_of_syracuse_virgin",
        "date": "2025-12-13",
        "dateDef": {
          "month": 12,
          "date": 13
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "names:lucy_of_syracuse_virgin"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "RED"
        ],
        "commonsDef": [
          "VirginMartyrs",
          "Virgins"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 14,
          "dayOfWeek": 6,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_2"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_2_saturday",
          "date": "2025-12-13",
          "dateDef": {
            "dateFn": "unprivilegedWeekdayOfAdvent",
            "dateArgs": [
              6,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.weekday",
            {
              "week": 2,
              "dow": 6
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 14,
            "dayOfWeek": 6,
            "nthDayOfWeekInMonth": 2,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-14": [
      {
        "id": "advent_3_sunday",
        "date": "2025-12-14",
        "dateDef": {
          "dateFn": "sundayOfAdvent",
          "dateArgs": [
            3
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_SUNDAY_2",
        "rank": "SUNDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.sunday",
          {
            "week": 3
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "ROSE",
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 15,
          "dayOfWeek": 0,
          "nthDayOfWeekInMonth": 2,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-15": [
      {
        "id": "advent_3_monday",
        "date": "2025-12-15",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            1,
            3
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 3,
            "dow": 1
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 16,
          "dayOfWeek": 1,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-16": [
      {
        "id": "advent_3_tuesday",
        "date": "2025-12-16",
        "dateDef": {
          "dateFn": "unprivilegedWeekdayOfAdvent",
          "dateArgs": [
            2,
            3
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.weekday",
          {
            "week": 3,
            "dow": 2
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 17,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-17": [
      {
        "id": "advent_december_17",
        "date": "2025-12-17",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            17
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 17
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 18,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-18": [
      {
        "id": "advent_december_18",
        "date": "2025-12-18",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            18
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 18
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 19,
          "dayOfWeek": 4,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-19": [
      {
        "id": "advent_december_19",
        "date": "2025-12-19",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            19
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 19
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 20,
          "dayOfWeek": 5,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-20": [
      {
        "id": "advent_december_20",
        "date": "2025-12-20",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            20
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 20
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 3,
          "dayOfSeason": 21,
          "dayOfWeek": 6,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_3"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-21": [
      {
        "id": "advent_4_sunday",
        "date": "2025-12-21",
        "dateDef": {
          "dateFn": "sundayOfAdvent",
          "dateArgs": [
            4
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_SUNDAY_2",
        "rank": "SUNDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.sunday",
          {
            "week": 4
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 4,
          "dayOfSeason": 22,
          "dayOfWeek": 0,
          "nthDayOfWeekInMonth": 3,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-22": [
      {
        "id": "advent_december_22",
        "date": "2025-12-22",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            22
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 22
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 4,
          "dayOfSeason": 23,
          "dayOfWeek": 1,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-23": [
      {
        "id": "advent_december_23",
        "date": "2025-12-23",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            23
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 23
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 4,
          "dayOfSeason": 24,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "john_of_kanty_priest",
        "date": "2025-12-23",
        "dateDef": {
          "month": 12,
          "date": 23
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:john_of_kanty_priest"
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [],
        "commonsDef": [
          "Pastors",
          "MercyWorkers"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 4,
          "dayOfSeason": 24,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "advent_december_23",
          "date": "2025-12-23",
          "dateDef": {
            "dateFn": "privilegedWeekdayOfAdvent",
            "dateArgs": [
              23
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "PRIVILEGED_WEEKDAY_9",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:advent.privileged_weekday",
            {
              "day": 23
            }
          ],
          "seasons": [
            "ADVENT"
          ],
          "periods": [],
          "colors": [
            "PURPLE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 4,
            "dayOfSeason": 24,
            "dayOfWeek": 2,
            "nthDayOfWeekInMonth": 4,
            "startOfSeason": "2025-11-30",
            "endOfSeason": "2025-12-24",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ADVENT"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_4"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-24": [
      {
        "id": "advent_december_24",
        "date": "2025-12-24",
        "dateDef": {
          "dateFn": "privilegedWeekdayOfAdvent",
          "dateArgs": [
            24
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:advent.privileged_weekday",
          {
            "day": 24
          }
        ],
        "seasons": [
          "ADVENT"
        ],
        "periods": [],
        "colors": [
          "PURPLE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 4,
          "dayOfSeason": 25,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-11-30",
          "endOfSeason": "2025-12-24",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "ADVENT"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-25": [
      {
        "id": "nativity_of_the_lord",
        "date": "2025-12-25",
        "dateDef": {
          "dateFn": "christmas",
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PROPER_OF_TIME_SOLEMNITY_2",
        "rank": "SOLEMNITY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "i18nDef": [
          "names:nativity_of_the_lord"
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 1,
          "dayOfWeek": 4,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-26": [
      {
        "id": "stephen_the_first_martyr",
        "date": "2025-12-26",
        "dateDef": {
          "month": 12,
          "date": 26
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "GENERAL_FEAST_7",
        "rank": "FEAST",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "names:stephen_the_first_martyr"
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "RED"
        ],
        "commonsDef": [
          "None"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 2,
          "dayOfWeek": 5,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "christmas_octave_day_2",
          "date": "2025-12-26",
          "dateDef": {
            "dateFn": "weekdayWithinOctaveOfChristmas",
            "dateArgs": [
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "PRIVILEGED_WEEKDAY_9",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:christmas_time.octave",
            {
              "count": 2
            }
          ],
          "seasons": [
            "CHRISTMAS_TIME"
          ],
          "periods": [
            "CHRISTMAS_OCTAVE",
            "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
          ],
          "colors": [
            "WHITE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 1,
            "dayOfSeason": 2,
            "dayOfWeek": 5,
            "nthDayOfWeekInMonth": 4,
            "startOfSeason": "2025-12-25",
            "endOfSeason": "2026-01-11",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "CHRISTMAS_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_4"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-27": [
      {
        "id": "john_apostle",
        "date": "2025-12-27",
        "dateDef": {
          "month": 12,
          "date": 27
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "GENERAL_FEAST_7",
        "rank": "FEAST",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "names:john_apostle"
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [
          "None"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 1,
          "dayOfSeason": 3,
          "dayOfWeek": 6,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_4"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "christmas_octave_day_3",
          "date": "2025-12-27",
          "dateDef": {
            "dateFn": "weekdayWithinOctaveOfChristmas",
            "dateArgs": [
              3
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "PRIVILEGED_WEEKDAY_9",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:christmas_time.octave",
            {
              "count": 3
            }
          ],
          "seasons": [
            "CHRISTMAS_TIME"
          ],
          "periods": [
            "CHRISTMAS_OCTAVE",
            "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
          ],
          "colors": [
            "WHITE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 1,
            "dayOfSeason": 3,
            "dayOfWeek": 6,
            "nthDayOfWeekInMonth": 4,
            "startOfSeason": "2025-12-25",
            "endOfSeason": "2026-01-11",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "CHRISTMAS_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_4"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-28": [
      {
        "id": "holy_family_of_jesus_mary_and_joseph",
        "date": "2025-12-28",
        "dateDef": {
          "dateFn": "holyFamily",
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "GENERAL_LORD_FEAST_5",
        "rank": "FEAST",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "i18nDef": [
          "names:holy_family_of_jesus_mary_and_joseph"
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 4,
          "dayOfWeek": 0,
          "nthDayOfWeekInMonth": 4,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-29": [
      {
        "id": "christmas_octave_day_5",
        "date": "2025-12-29",
        "dateDef": {
          "dateFn": "weekdayWithinOctaveOfChristmas",
          "dateArgs": [
            5
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:christmas_time.octave",
          {
            "count": 5
          }
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 5,
          "dayOfWeek": 1,
          "nthDayOfWeekInMonth": 5,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "thomas_becket_bishop",
        "date": "2025-12-29",
        "dateDef": {
          "month": 12,
          "date": 29
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:thomas_becket_bishop"
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [],
        "commonsDef": [
          "Martyrs",
          "Bishops"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 5,
          "dayOfWeek": 1,
          "nthDayOfWeekInMonth": 5,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "christmas_octave_day_5",
          "date": "2025-12-29",
          "dateDef": {
            "dateFn": "weekdayWithinOctaveOfChristmas",
            "dateArgs": [
              5
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "PRIVILEGED_WEEKDAY_9",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:christmas_time.octave",
            {
              "count": 5
            }
          ],
          "seasons": [
            "CHRISTMAS_TIME"
          ],
          "periods": [
            "CHRISTMAS_OCTAVE",
            "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
          ],
          "colors": [
            "WHITE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 5,
            "dayOfWeek": 1,
            "nthDayOfWeekInMonth": 5,
            "startOfSeason": "2025-12-25",
            "endOfSeason": "2026-01-11",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "CHRISTMAS_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2025-12-30": [
      {
        "id": "christmas_octave_day_6",
        "date": "2025-12-30",
        "dateDef": {
          "dateFn": "weekdayWithinOctaveOfChristmas",
          "dateArgs": [
            6
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:christmas_time.octave",
          {
            "count": 6
          }
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 6,
          "dayOfWeek": 2,
          "nthDayOfWeekInMonth": 5,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      }
    ],
    "2025-12-31": [
      {
        "id": "christmas_octave_day_7",
        "date": "2025-12-31",
        "dateDef": {
          "dateFn": "weekdayWithinOctaveOfChristmas",
          "dateArgs": [
            7
          ],
          "yearOffset": 0
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "PRIVILEGED_WEEKDAY_9",
        "rank": "WEEKDAY",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "i18nDef": [
          "seasons:christmas_time.octave",
          {
            "count": 7
          }
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [
          "WHITE"
        ],
        "commonsDef": [],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 7,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 5,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_TIME",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ProperOfTime",
        "fromExtendedCalendars": []
      },
      {
        "id": "sylvester_i_pope",
        "date": "2025-12-31",
        "dateDef": {
          "month": 12,
          "date": 31
        },
        "dateExceptions": [],
        "alternativeTransferDateDefs": [],
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "allowSimilarRankItems": false,
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "i18nDef": [
          "names:sylvester_i_pope"
        ],
        "seasons": [
          "CHRISTMAS_TIME"
        ],
        "periods": [
          "CHRISTMAS_OCTAVE",
          "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
        ],
        "colors": [],
        "commonsDef": [
          "PopeOrBishop"
        ],
        "martyrology": [],
        "titles": [],
        "calendar": {
          "weekOfSeason": 2,
          "dayOfSeason": 7,
          "dayOfWeek": 3,
          "nthDayOfWeekInMonth": 5,
          "startOfSeason": "2025-12-25",
          "endOfSeason": "2026-01-11",
          "startOfLiturgicalYear": "2025-11-30",
          "endOfLiturgicalYear": "2026-11-28",
          "seasons": [
            "CHRISTMAS_TIME"
          ]
        },
        "cycles": {
          "properCycle": "PROPER_OF_SAINTS",
          "sundayCycle": "YEAR_A",
          "weekdayCycle": "YEAR_2",
          "psalterWeek": "WEEK_1"
        },
        "fromCalendarId": "ma",
        "fromExtendedCalendars": [],
        "weekday": {
          "id": "christmas_octave_day_7",
          "date": "2025-12-31",
          "dateDef": {
            "dateFn": "weekdayWithinOctaveOfChristmas",
            "dateArgs": [
              7
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "PRIVILEGED_WEEKDAY_9",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:christmas_time.octave",
            {
              "count": 7
            }
          ],
          "seasons": [
            "CHRISTMAS_TIME"
          ],
          "periods": [
            "CHRISTMAS_OCTAVE",
            "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
          ],
          "colors": [
            "WHITE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 7,
            "dayOfWeek": 3,
            "nthDayOfWeekInMonth": 5,
            "startOfSeason": "2025-12-25",
            "endOfSeason": "2026-01-11",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "CHRISTMAS_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ]
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/liturgicalcalendar?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/liturgicalcalendar?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/liturgicalcalendar?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
