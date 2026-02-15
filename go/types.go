// Package liturgicalcalendar provides a Go client for the Liturgical Calendar API.
//
// For more information, visit: https://apiverve.com/marketplace/liturgicalcalendar?utm_source=go&utm_medium=readme
package liturgicalcalendar

import (
	"fmt"
	"reflect"
	"regexp"
	"strings"
)

// ValidationRule defines validation constraints for a parameter.
type ValidationRule struct {
	Type      string
	Required  bool
	Min       *float64
	Max       *float64
	MinLength *int
	MaxLength *int
	Format    string
	Enum      []string
}

// ValidationError represents a parameter validation error.
type ValidationError struct {
	Errors []string
}

func (e *ValidationError) Error() string {
	return "Validation failed: " + strings.Join(e.Errors, "; ")
}

// Helper functions for pointers
func float64Ptr(v float64) *float64 { return &v }
func intPtr(v int) *int             { return &v }

// Format validation patterns
var formatPatterns = map[string]*regexp.Regexp{
	"email":    regexp.MustCompile(`^[^\s@]+@[^\s@]+\.[^\s@]+$`),
	"url":      regexp.MustCompile(`^https?://.+`),
	"ip":       regexp.MustCompile(`^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$`),
	"date":     regexp.MustCompile(`^\d{4}-\d{2}-\d{2}$`),
	"hexColor": regexp.MustCompile(`^#?([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$`),
}

// Request contains the parameters for the Liturgical Calendar API.
//
// Parameters:
//   - month: integer - The month to get Liturgical Calendar data for (default: current month) [min: 1, max: 12]
//   - year: integer - The year to get Liturgical Calendar data for (default: current year) [min: 1900, max: 2100]
type Request struct {
	Month int `json:"month,omitempty"` // Optional
	Year int `json:"year,omitempty"` // Optional
}

// ToQueryParams converts the request struct to a map of query parameters.
// Only non-zero values are included.
func (r *Request) ToQueryParams() map[string]string {
	params := make(map[string]string)
	if r == nil {
		return params
	}

	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		// Get the json tag for the field name
		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		// Handle tags like `json:"name,omitempty"`
		jsonName := strings.Split(jsonTag, ",")[0]
		if jsonName == "-" {
			continue
		}

		// Skip zero values
		if field.IsZero() {
			continue
		}

		// Convert to string
		params[jsonName] = fmt.Sprintf("%v", field.Interface())
	}

	return params
}

// Validate checks the request parameters against validation rules.
// Returns a ValidationError if validation fails, nil otherwise.
func (r *Request) Validate() error {
	rules := map[string]ValidationRule{
		"month": {Type: "integer", Required: false, Min: float64Ptr(1), Max: float64Ptr(12)},
		"year": {Type: "integer", Required: false, Min: float64Ptr(1900), Max: float64Ptr(2100)},
	}

	if len(rules) == 0 {
		return nil
	}

	var errors []string
	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		jsonName := strings.Split(jsonTag, ",")[0]

		rule, exists := rules[jsonName]
		if !exists {
			continue
		}

		// Check required
		if rule.Required && field.IsZero() {
			errors = append(errors, fmt.Sprintf("Required parameter [%s] is missing", jsonName))
			continue
		}

		if field.IsZero() {
			continue
		}

		// Type-specific validation
		switch rule.Type {
		case "integer", "number":
			var numVal float64
			switch field.Kind() {
			case reflect.Int, reflect.Int64:
				numVal = float64(field.Int())
			case reflect.Float64:
				numVal = field.Float()
			}
			if rule.Min != nil && numVal < *rule.Min {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %v", jsonName, *rule.Min))
			}
			if rule.Max != nil && numVal > *rule.Max {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %v", jsonName, *rule.Max))
			}

		case "string":
			strVal := field.String()
			if rule.MinLength != nil && len(strVal) < *rule.MinLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %d characters", jsonName, *rule.MinLength))
			}
			if rule.MaxLength != nil && len(strVal) > *rule.MaxLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %d characters", jsonName, *rule.MaxLength))
			}
			if rule.Format != "" {
				if pattern, ok := formatPatterns[rule.Format]; ok {
					if !pattern.MatchString(strVal) {
						errors = append(errors, fmt.Sprintf("Parameter [%s] must be a valid %s", jsonName, rule.Format))
					}
				}
			}
		}

		// Enum validation
		if len(rule.Enum) > 0 {
			strVal := fmt.Sprintf("%v", field.Interface())
			found := false
			for _, enumVal := range rule.Enum {
				if strVal == enumVal {
					found = true
					break
				}
			}
			if !found {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be one of: %s", jsonName, strings.Join(rule.Enum, ", ")))
			}
		}
	}

	if len(errors) > 0 {
		return &ValidationError{Errors: errors}
	}
	return nil
}

// ResponseData contains the data returned by the Liturgical Calendar API.
type ResponseData struct {
	2025-03-01 []2025-03-01Item `json:"2025-03-01"`
	2025-03-02 []2025-03-02Item `json:"2025-03-02"`
	2025-03-03 []2025-03-03Item `json:"2025-03-03"`
	2025-03-04 []2025-03-04Item `json:"2025-03-04"`
	2025-03-05 []2025-03-05Item `json:"2025-03-05"`
	2025-03-06 []2025-03-06Item `json:"2025-03-06"`
	2025-03-07 []2025-03-07Item `json:"2025-03-07"`
	2025-03-08 []2025-03-08Item `json:"2025-03-08"`
	2025-03-09 []2025-03-09Item `json:"2025-03-09"`
	2025-03-10 []2025-03-10Item `json:"2025-03-10"`
	2025-03-11 []2025-03-11Item `json:"2025-03-11"`
	2025-03-12 []2025-03-12Item `json:"2025-03-12"`
	2025-03-13 []2025-03-13Item `json:"2025-03-13"`
	2025-03-14 []2025-03-14Item `json:"2025-03-14"`
	2025-03-15 []2025-03-15Item `json:"2025-03-15"`
	2025-03-16 []2025-03-16Item `json:"2025-03-16"`
	2025-03-17 []2025-03-17Item `json:"2025-03-17"`
	2025-03-18 []2025-03-18Item `json:"2025-03-18"`
	2025-03-19 []2025-03-19Item `json:"2025-03-19"`
	2025-03-20 []2025-03-20Item `json:"2025-03-20"`
	2025-03-21 []2025-03-21Item `json:"2025-03-21"`
	2025-03-22 []2025-03-22Item `json:"2025-03-22"`
	2025-03-23 []2025-03-23Item `json:"2025-03-23"`
	2025-03-24 []2025-03-24Item `json:"2025-03-24"`
	2025-03-25 []2025-03-25Item `json:"2025-03-25"`
	2025-03-26 []2025-03-26Item `json:"2025-03-26"`
	2025-03-27 []2025-03-27Item `json:"2025-03-27"`
	2025-03-28 []2025-03-28Item `json:"2025-03-28"`
	2025-03-29 []2025-03-29Item `json:"2025-03-29"`
	2025-03-30 []2025-03-30Item `json:"2025-03-30"`
	2025-03-31 []2025-03-31Item `json:"2025-03-31"`
}

// 2025-03-01Item represents an item in the 2025-03-01 array.
type 2025-03-01Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	DateArgs []int `json:"dateArgs"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-02Item represents an item in the 2025-03-02 array.
type 2025-03-02Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	DateArgs []int `json:"dateArgs"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-03Item represents an item in the 2025-03-03 array.
type 2025-03-03Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	DateArgs []int `json:"dateArgs"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-04Item represents an item in the 2025-03-04 array.
type 2025-03-04Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	DateArgs []int `json:"dateArgs"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-05Item represents an item in the 2025-03-05 array.
type 2025-03-05Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-06Item represents an item in the 2025-03-06 array.
type 2025-03-06Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-07Item represents an item in the 2025-03-07 array.
type 2025-03-07Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-08Item represents an item in the 2025-03-08 array.
type 2025-03-08Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-09Item represents an item in the 2025-03-09 array.
type 2025-03-09Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-10Item represents an item in the 2025-03-10 array.
type 2025-03-10Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-11Item represents an item in the 2025-03-11 array.
type 2025-03-11Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-12Item represents an item in the 2025-03-12 array.
type 2025-03-12Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-13Item represents an item in the 2025-03-13 array.
type 2025-03-13Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-14Item represents an item in the 2025-03-14 array.
type 2025-03-14Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-15Item represents an item in the 2025-03-15 array.
type 2025-03-15Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-16Item represents an item in the 2025-03-16 array.
type 2025-03-16Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-17Item represents an item in the 2025-03-17 array.
type 2025-03-17Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-18Item represents an item in the 2025-03-18 array.
type 2025-03-18Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-19Item represents an item in the 2025-03-19 array.
type 2025-03-19Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []DateExceptionsItem `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []string `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	Month int `json:"month"`
	Date int `json:"date"`
}

// DateExceptionsItem represents an item in the DateExceptions array.
type DateExceptionsItem struct {
	IfIsDayOfWeek int `json:"ifIsDayOfWeek"`
	SetDate SetDateData `json:"setDate"`
}

// SetDateData represents the setDate object.
type SetDateData struct {
	AddDay int `json:"addDay"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-20Item represents an item in the 2025-03-20 array.
type 2025-03-20Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-21Item represents an item in the 2025-03-21 array.
type 2025-03-21Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-22Item represents an item in the 2025-03-22 array.
type 2025-03-22Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-23Item represents an item in the 2025-03-23 array.
type 2025-03-23Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-24Item represents an item in the 2025-03-24 array.
type 2025-03-24Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-25Item represents an item in the 2025-03-25 array.
type 2025-03-25Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []string `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-26Item represents an item in the 2025-03-26 array.
type 2025-03-26Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-27Item represents an item in the 2025-03-27 array.
type 2025-03-27Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-28Item represents an item in the 2025-03-28 array.
type 2025-03-28Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-29Item represents an item in the 2025-03-29 array.
type 2025-03-29Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-30Item represents an item in the 2025-03-30 array.
type 2025-03-30Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}

// 2025-03-31Item represents an item in the 2025-03-31 array.
type 2025-03-31Item struct {
	Id string `json:"id"`
	Date string `json:"date"`
	DateDef DateDefData `json:"dateDef"`
	DateExceptions []interface{} `json:"dateExceptions"`
	AlternativeTransferDateDefs []interface{} `json:"alternativeTransferDateDefs"`
	Precedence string `json:"precedence"`
	Rank string `json:"rank"`
	AllowSimilarRankItems bool `json:"allowSimilarRankItems"`
	IsHolyDayOfObligation bool `json:"isHolyDayOfObligation"`
	IsOptional bool `json:"isOptional"`
	I18nDef []string `json:"i18nDef"`
	Seasons []string `json:"seasons"`
	Periods []string `json:"periods"`
	Colors []string `json:"colors"`
	CommonsDef []interface{} `json:"commonsDef"`
	Martyrology []interface{} `json:"martyrology"`
	Titles []interface{} `json:"titles"`
	Calendar CalendarData `json:"calendar"`
	Cycles CyclesData `json:"cycles"`
	FromCalendarId string `json:"fromCalendarId"`
	FromExtendedCalendars []interface{} `json:"fromExtendedCalendars"`
}

// DateDefData represents the dateDef object.
type DateDefData struct {
	DateFn string `json:"dateFn"`
	AddDay int `json:"addDay"`
	YearOffset int `json:"yearOffset"`
}

// CalendarData represents the calendar object.
type CalendarData struct {
	WeekOfSeason int `json:"weekOfSeason"`
	DayOfSeason int `json:"dayOfSeason"`
	DayOfWeek int `json:"dayOfWeek"`
	NthDayOfWeekInMonth int `json:"nthDayOfWeekInMonth"`
	StartOfSeason string `json:"startOfSeason"`
	EndOfSeason string `json:"endOfSeason"`
	StartOfLiturgicalYear string `json:"startOfLiturgicalYear"`
	EndOfLiturgicalYear string `json:"endOfLiturgicalYear"`
	Seasons []string `json:"seasons"`
}

// CyclesData represents the cycles object.
type CyclesData struct {
	ProperCycle string `json:"properCycle"`
	SundayCycle string `json:"sundayCycle"`
	WeekdayCycle string `json:"weekdayCycle"`
	PsalterWeek string `json:"psalterWeek"`
}
