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
        /// The month to get Liturgical Calendar data for (default: current month)
        /// </summary>
        [JsonProperty("month")]
        public int? Month { get; set; }

        /// <summary>
        /// The year to get Liturgical Calendar data for (default: current year)
        /// </summary>
        [JsonProperty("year")]
        public int? Year { get; set; }
    }
}
