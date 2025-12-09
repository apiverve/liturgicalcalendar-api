using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.LiturgicalCalendar
{
    /// <summary>
    /// Query options for the Liturgical Calendar API
    /// </summary>
    public class LiturgicalCalendarQueryOptions
    {
        /// <summary>
        /// The two digit month you want to get the Liturgical Calendar data for (default: current month)
        /// Example: 02
        /// </summary>
        [JsonProperty("month")]
        public string Month { get; set; }

        /// <summary>
        /// The 4 digit year you want to get the Liturgical Calendar data for (default: current year)
        /// Example: 2025
        /// </summary>
        [JsonProperty("year")]
        public string Year { get; set; }
    }
}
