// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     LiturgicalCalendarData data = Converter.fromJsonString(jsonString);

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static LiturgicalCalendarData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(LiturgicalCalendarData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(LiturgicalCalendarData.class);
        writer = mapper.writerFor(LiturgicalCalendarData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// LiturgicalCalendarData.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class LiturgicalCalendarData {
    private The20250301[] the20250301;
    private The20250302[] the20250302;
    private The20250301[] the20250303;
    private The20250304[] the20250304;
    private The20250305[] the20250305;
    private The20250306[] the20250306;
    private The2025030[] the20250307;
    private The2025030[] the20250308;
    private The202503[] the20250309;
    private The20250310[] the20250310;
    private The20250310[] the20250311;
    private The20250310[] the20250312;
    private The20250310[] the20250313;
    private The20250310[] the20250314;
    private The20250310[] the20250315;
    private The202503[] the20250316;
    private The2025031[] the20250317;
    private The2025031[] the20250318;
    private The20250319[] the20250319;
    private The20250310[] the20250320;
    private The20250310[] the20250321;
    private The20250310[] the20250322;
    private The202503[] the20250323;
    private The20250310[] the20250324;
    private The20250325[] the20250325;
    private The20250310[] the20250326;
    private The20250310[] the20250327;
    private The20250310[] the20250328;
    private The20250310[] the20250329;
    private The202503[] the20250330;
    private The20250310[] the20250331;

    @JsonProperty("2025-03-01")
    public The20250301[] getThe20250301() { return the20250301; }
    @JsonProperty("2025-03-01")
    public void setThe20250301(The20250301[] value) { this.the20250301 = value; }

    @JsonProperty("2025-03-02")
    public The20250302[] getThe20250302() { return the20250302; }
    @JsonProperty("2025-03-02")
    public void setThe20250302(The20250302[] value) { this.the20250302 = value; }

    @JsonProperty("2025-03-03")
    public The20250301[] getThe20250303() { return the20250303; }
    @JsonProperty("2025-03-03")
    public void setThe20250303(The20250301[] value) { this.the20250303 = value; }

    @JsonProperty("2025-03-04")
    public The20250304[] getThe20250304() { return the20250304; }
    @JsonProperty("2025-03-04")
    public void setThe20250304(The20250304[] value) { this.the20250304 = value; }

    @JsonProperty("2025-03-05")
    public The20250305[] getThe20250305() { return the20250305; }
    @JsonProperty("2025-03-05")
    public void setThe20250305(The20250305[] value) { this.the20250305 = value; }

    @JsonProperty("2025-03-06")
    public The20250306[] getThe20250306() { return the20250306; }
    @JsonProperty("2025-03-06")
    public void setThe20250306(The20250306[] value) { this.the20250306 = value; }

    @JsonProperty("2025-03-07")
    public The2025030[] getThe20250307() { return the20250307; }
    @JsonProperty("2025-03-07")
    public void setThe20250307(The2025030[] value) { this.the20250307 = value; }

    @JsonProperty("2025-03-08")
    public The2025030[] getThe20250308() { return the20250308; }
    @JsonProperty("2025-03-08")
    public void setThe20250308(The2025030[] value) { this.the20250308 = value; }

    @JsonProperty("2025-03-09")
    public The202503[] getThe20250309() { return the20250309; }
    @JsonProperty("2025-03-09")
    public void setThe20250309(The202503[] value) { this.the20250309 = value; }

    @JsonProperty("2025-03-10")
    public The20250310[] getThe20250310() { return the20250310; }
    @JsonProperty("2025-03-10")
    public void setThe20250310(The20250310[] value) { this.the20250310 = value; }

    @JsonProperty("2025-03-11")
    public The20250310[] getThe20250311() { return the20250311; }
    @JsonProperty("2025-03-11")
    public void setThe20250311(The20250310[] value) { this.the20250311 = value; }

    @JsonProperty("2025-03-12")
    public The20250310[] getThe20250312() { return the20250312; }
    @JsonProperty("2025-03-12")
    public void setThe20250312(The20250310[] value) { this.the20250312 = value; }

    @JsonProperty("2025-03-13")
    public The20250310[] getThe20250313() { return the20250313; }
    @JsonProperty("2025-03-13")
    public void setThe20250313(The20250310[] value) { this.the20250313 = value; }

    @JsonProperty("2025-03-14")
    public The20250310[] getThe20250314() { return the20250314; }
    @JsonProperty("2025-03-14")
    public void setThe20250314(The20250310[] value) { this.the20250314 = value; }

    @JsonProperty("2025-03-15")
    public The20250310[] getThe20250315() { return the20250315; }
    @JsonProperty("2025-03-15")
    public void setThe20250315(The20250310[] value) { this.the20250315 = value; }

    @JsonProperty("2025-03-16")
    public The202503[] getThe20250316() { return the20250316; }
    @JsonProperty("2025-03-16")
    public void setThe20250316(The202503[] value) { this.the20250316 = value; }

    @JsonProperty("2025-03-17")
    public The2025031[] getThe20250317() { return the20250317; }
    @JsonProperty("2025-03-17")
    public void setThe20250317(The2025031[] value) { this.the20250317 = value; }

    @JsonProperty("2025-03-18")
    public The2025031[] getThe20250318() { return the20250318; }
    @JsonProperty("2025-03-18")
    public void setThe20250318(The2025031[] value) { this.the20250318 = value; }

    @JsonProperty("2025-03-19")
    public The20250319[] getThe20250319() { return the20250319; }
    @JsonProperty("2025-03-19")
    public void setThe20250319(The20250319[] value) { this.the20250319 = value; }

    @JsonProperty("2025-03-20")
    public The20250310[] getThe20250320() { return the20250320; }
    @JsonProperty("2025-03-20")
    public void setThe20250320(The20250310[] value) { this.the20250320 = value; }

    @JsonProperty("2025-03-21")
    public The20250310[] getThe20250321() { return the20250321; }
    @JsonProperty("2025-03-21")
    public void setThe20250321(The20250310[] value) { this.the20250321 = value; }

    @JsonProperty("2025-03-22")
    public The20250310[] getThe20250322() { return the20250322; }
    @JsonProperty("2025-03-22")
    public void setThe20250322(The20250310[] value) { this.the20250322 = value; }

    @JsonProperty("2025-03-23")
    public The202503[] getThe20250323() { return the20250323; }
    @JsonProperty("2025-03-23")
    public void setThe20250323(The202503[] value) { this.the20250323 = value; }

    @JsonProperty("2025-03-24")
    public The20250310[] getThe20250324() { return the20250324; }
    @JsonProperty("2025-03-24")
    public void setThe20250324(The20250310[] value) { this.the20250324 = value; }

    @JsonProperty("2025-03-25")
    public The20250325[] getThe20250325() { return the20250325; }
    @JsonProperty("2025-03-25")
    public void setThe20250325(The20250325[] value) { this.the20250325 = value; }

    @JsonProperty("2025-03-26")
    public The20250310[] getThe20250326() { return the20250326; }
    @JsonProperty("2025-03-26")
    public void setThe20250326(The20250310[] value) { this.the20250326 = value; }

    @JsonProperty("2025-03-27")
    public The20250310[] getThe20250327() { return the20250327; }
    @JsonProperty("2025-03-27")
    public void setThe20250327(The20250310[] value) { this.the20250327 = value; }

    @JsonProperty("2025-03-28")
    public The20250310[] getThe20250328() { return the20250328; }
    @JsonProperty("2025-03-28")
    public void setThe20250328(The20250310[] value) { this.the20250328 = value; }

    @JsonProperty("2025-03-29")
    public The20250310[] getThe20250329() { return the20250329; }
    @JsonProperty("2025-03-29")
    public void setThe20250329(The20250310[] value) { this.the20250329 = value; }

    @JsonProperty("2025-03-30")
    public The202503[] getThe20250330() { return the20250330; }
    @JsonProperty("2025-03-30")
    public void setThe20250330(The202503[] value) { this.the20250330 = value; }

    @JsonProperty("2025-03-31")
    public The20250310[] getThe20250331() { return the20250331; }
    @JsonProperty("2025-03-31")
    public void setThe20250331(The20250310[] value) { this.the20250331 = value; }
}

// The20250301.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250301 {
    private String id;
    private LocalDate date;
    private The20250301_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private Rank rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250301_I18NDef[] i18NDef;
    private Season[] seasons;
    private String[] periods;
    private String[] colors;
    private Object[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private FromCalendarID fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250301_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250301_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public Rank getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(Rank value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250301_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250301_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public String[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(String[] value) { this.periods = value; }

    @JsonProperty("colors")
    public String[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(String[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public Object[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(Object[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public FromCalendarID getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(FromCalendarID value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// Calendar.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class Calendar {
    private long weekOfSeason;
    private long dayOfSeason;
    private long dayOfWeek;
    private long nthDayOfWeekInMonth;
    private LocalDate startOfSeason;
    private LocalDate endOfSeason;
    private LocalDate startOfLiturgicalYear;
    private LocalDate endOfLiturgicalYear;
    private Season[] seasons;

    @JsonProperty("weekOfSeason")
    public long getWeekOfSeason() { return weekOfSeason; }
    @JsonProperty("weekOfSeason")
    public void setWeekOfSeason(long value) { this.weekOfSeason = value; }

    @JsonProperty("dayOfSeason")
    public long getDayOfSeason() { return dayOfSeason; }
    @JsonProperty("dayOfSeason")
    public void setDayOfSeason(long value) { this.dayOfSeason = value; }

    @JsonProperty("dayOfWeek")
    public long getDayOfWeek() { return dayOfWeek; }
    @JsonProperty("dayOfWeek")
    public void setDayOfWeek(long value) { this.dayOfWeek = value; }

    @JsonProperty("nthDayOfWeekInMonth")
    public long getNthDayOfWeekInMonth() { return nthDayOfWeekInMonth; }
    @JsonProperty("nthDayOfWeekInMonth")
    public void setNthDayOfWeekInMonth(long value) { this.nthDayOfWeekInMonth = value; }

    @JsonProperty("startOfSeason")
    public LocalDate getStartOfSeason() { return startOfSeason; }
    @JsonProperty("startOfSeason")
    public void setStartOfSeason(LocalDate value) { this.startOfSeason = value; }

    @JsonProperty("endOfSeason")
    public LocalDate getEndOfSeason() { return endOfSeason; }
    @JsonProperty("endOfSeason")
    public void setEndOfSeason(LocalDate value) { this.endOfSeason = value; }

    @JsonProperty("startOfLiturgicalYear")
    public LocalDate getStartOfLiturgicalYear() { return startOfLiturgicalYear; }
    @JsonProperty("startOfLiturgicalYear")
    public void setStartOfLiturgicalYear(LocalDate value) { this.startOfLiturgicalYear = value; }

    @JsonProperty("endOfLiturgicalYear")
    public LocalDate getEndOfLiturgicalYear() { return endOfLiturgicalYear; }
    @JsonProperty("endOfLiturgicalYear")
    public void setEndOfLiturgicalYear(LocalDate value) { this.endOfLiturgicalYear = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }
}

// Season.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Season {
    LENT, ORDINARY_TIME;

    @JsonValue
    public String toValue() {
        switch (this) {
            case LENT: return "LENT";
            case ORDINARY_TIME: return "ORDINARY_TIME";
        }
        return null;
    }

    @JsonCreator
    public static Season forValue(String value) throws IOException {
        if (value.equals("LENT")) return LENT;
        if (value.equals("ORDINARY_TIME")) return ORDINARY_TIME;
        throw new IOException("Cannot deserialize Season");
    }
}

// Cycles.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class Cycles {
    private ProperCycle properCycle;
    private SundayCycle sundayCycle;
    private WeekdayCycle weekdayCycle;
    private PsalterWeek psalterWeek;

    @JsonProperty("properCycle")
    public ProperCycle getProperCycle() { return properCycle; }
    @JsonProperty("properCycle")
    public void setProperCycle(ProperCycle value) { this.properCycle = value; }

    @JsonProperty("sundayCycle")
    public SundayCycle getSundayCycle() { return sundayCycle; }
    @JsonProperty("sundayCycle")
    public void setSundayCycle(SundayCycle value) { this.sundayCycle = value; }

    @JsonProperty("weekdayCycle")
    public WeekdayCycle getWeekdayCycle() { return weekdayCycle; }
    @JsonProperty("weekdayCycle")
    public void setWeekdayCycle(WeekdayCycle value) { this.weekdayCycle = value; }

    @JsonProperty("psalterWeek")
    public PsalterWeek getPsalterWeek() { return psalterWeek; }
    @JsonProperty("psalterWeek")
    public void setPsalterWeek(PsalterWeek value) { this.psalterWeek = value; }
}

// ProperCycle.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ProperCycle {
    PROPER_OF_SAINTS, PROPER_OF_TIME;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PROPER_OF_SAINTS: return "PROPER_OF_SAINTS";
            case PROPER_OF_TIME: return "PROPER_OF_TIME";
        }
        return null;
    }

    @JsonCreator
    public static ProperCycle forValue(String value) throws IOException {
        if (value.equals("PROPER_OF_SAINTS")) return PROPER_OF_SAINTS;
        if (value.equals("PROPER_OF_TIME")) return PROPER_OF_TIME;
        throw new IOException("Cannot deserialize ProperCycle");
    }
}

// PsalterWeek.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum PsalterWeek {
    WEEK_1, WEEK_2, WEEK_3, WEEK_4;

    @JsonValue
    public String toValue() {
        switch (this) {
            case WEEK_1: return "WEEK_1";
            case WEEK_2: return "WEEK_2";
            case WEEK_3: return "WEEK_3";
            case WEEK_4: return "WEEK_4";
        }
        return null;
    }

    @JsonCreator
    public static PsalterWeek forValue(String value) throws IOException {
        if (value.equals("WEEK_1")) return WEEK_1;
        if (value.equals("WEEK_2")) return WEEK_2;
        if (value.equals("WEEK_3")) return WEEK_3;
        if (value.equals("WEEK_4")) return WEEK_4;
        throw new IOException("Cannot deserialize PsalterWeek");
    }
}

// SundayCycle.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum SundayCycle {
    YEAR_C;

    @JsonValue
    public String toValue() {
        switch (this) {
            case YEAR_C: return "YEAR_C";
        }
        return null;
    }

    @JsonCreator
    public static SundayCycle forValue(String value) throws IOException {
        if (value.equals("YEAR_C")) return YEAR_C;
        throw new IOException("Cannot deserialize SundayCycle");
    }
}

// WeekdayCycle.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum WeekdayCycle {
    YEAR_1;

    @JsonValue
    public String toValue() {
        switch (this) {
            case YEAR_1: return "YEAR_1";
        }
        return null;
    }

    @JsonCreator
    public static WeekdayCycle forValue(String value) throws IOException {
        if (value.equals("YEAR_1")) return YEAR_1;
        throw new IOException("Cannot deserialize WeekdayCycle");
    }
}

// The20250301_DateDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class The20250301_DateDef {
    private String dateFn;
    private long[] dateArgs;
    private long yearOffset;

    @JsonProperty("dateFn")
    public String getDateFn() { return dateFn; }
    @JsonProperty("dateFn")
    public void setDateFn(String value) { this.dateFn = value; }

    @JsonProperty("dateArgs")
    public long[] getDateArgs() { return dateArgs; }
    @JsonProperty("dateArgs")
    public void setDateArgs(long[] value) { this.dateArgs = value; }

    @JsonProperty("yearOffset")
    public long getYearOffset() { return yearOffset; }
    @JsonProperty("yearOffset")
    public void setYearOffset(long value) { this.yearOffset = value; }
}

// FromCalendarID.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum FromCalendarID {
    PROPER_OF_TIME;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PROPER_OF_TIME: return "ProperOfTime";
        }
        return null;
    }

    @JsonCreator
    public static FromCalendarID forValue(String value) throws IOException {
        if (value.equals("ProperOfTime")) return PROPER_OF_TIME;
        throw new IOException("Cannot deserialize FromCalendarID");
    }
}

// The20250301_I18NDef.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = The20250301_I18NDef.Deserializer.class)
@JsonSerialize(using = The20250301_I18NDef.Serializer.class)
public class The20250301_I18NDef {
    public PurpleI18NDef purpleI18NDefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<The20250301_I18NDef> {
        @Override
        public The20250301_I18NDef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            The20250301_I18NDef value = new The20250301_I18NDef();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.purpleI18NDefValue = jsonParser.readValueAs(PurpleI18NDef.class);
                    break;
                default: throw new IOException("Cannot deserialize The20250301_I18NDef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<The20250301_I18NDef> {
        @Override
        public void serialize(The20250301_I18NDef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleI18NDefValue != null) {
                jsonGenerator.writeObject(obj.purpleI18NDefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("The20250301_I18NDef must not be null");
        }
    }
}

// PurpleI18NDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class PurpleI18NDef {
    private long week;
    private long dow;

    @JsonProperty("week")
    public long getWeek() { return week; }
    @JsonProperty("week")
    public void setWeek(long value) { this.week = value; }

    @JsonProperty("dow")
    public long getDow() { return dow; }
    @JsonProperty("dow")
    public void setDow(long value) { this.dow = value; }
}

// Rank.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Rank {
    WEEKDAY;

    @JsonValue
    public String toValue() {
        switch (this) {
            case WEEKDAY: return "WEEKDAY";
        }
        return null;
    }

    @JsonCreator
    public static Rank forValue(String value) throws IOException {
        if (value.equals("WEEKDAY")) return WEEKDAY;
        throw new IOException("Cannot deserialize Rank");
    }
}

// The20250302.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250302 {
    private String id;
    private LocalDate date;
    private The20250301_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250302_I18NDef[] i18NDef;
    private Season[] seasons;
    private String[] periods;
    private String[] colors;
    private Object[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private FromCalendarID fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250301_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250301_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250302_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250302_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public String[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(String[] value) { this.periods = value; }

    @JsonProperty("colors")
    public String[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(String[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public Object[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(Object[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public FromCalendarID getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(FromCalendarID value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// The20250302_I18NDef.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = The20250302_I18NDef.Deserializer.class)
@JsonSerialize(using = The20250302_I18NDef.Serializer.class)
public class The20250302_I18NDef {
    public FluffyI18NDef fluffyI18NDefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<The20250302_I18NDef> {
        @Override
        public The20250302_I18NDef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            The20250302_I18NDef value = new The20250302_I18NDef();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.fluffyI18NDefValue = jsonParser.readValueAs(FluffyI18NDef.class);
                    break;
                default: throw new IOException("Cannot deserialize The20250302_I18NDef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<The20250302_I18NDef> {
        @Override
        public void serialize(The20250302_I18NDef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.fluffyI18NDefValue != null) {
                jsonGenerator.writeObject(obj.fluffyI18NDefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("The20250302_I18NDef must not be null");
        }
    }
}

// FluffyI18NDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class FluffyI18NDef {
    private long week;

    @JsonProperty("week")
    public long getWeek() { return week; }
    @JsonProperty("week")
    public void setWeek(long value) { this.week = value; }
}

// The20250304.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250304 {
    private String id;
    private LocalDate date;
    private The20250304_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250301_I18NDef[] i18NDef;
    private Season[] seasons;
    private String[] periods;
    private String[] colors;
    private String[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private String fromCalendarID;
    private Object[] fromExtendedCalendars;
    private The20250301 weekday;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250304_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250304_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250301_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250301_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public String[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(String[] value) { this.periods = value; }

    @JsonProperty("colors")
    public String[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(String[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public String[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(String[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public String getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(String value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }

    @JsonProperty("weekday")
    public The20250301 getWeekday() { return weekday; }
    @JsonProperty("weekday")
    public void setWeekday(The20250301 value) { this.weekday = value; }
}

// The20250304_DateDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class The20250304_DateDef {
    private String dateFn;
    private long[] dateArgs;
    private Long yearOffset;
    private Long month;
    private Long date;
    private Long addDay;

    @JsonProperty("dateFn")
    public String getDateFn() { return dateFn; }
    @JsonProperty("dateFn")
    public void setDateFn(String value) { this.dateFn = value; }

    @JsonProperty("dateArgs")
    public long[] getDateArgs() { return dateArgs; }
    @JsonProperty("dateArgs")
    public void setDateArgs(long[] value) { this.dateArgs = value; }

    @JsonProperty("yearOffset")
    public Long getYearOffset() { return yearOffset; }
    @JsonProperty("yearOffset")
    public void setYearOffset(Long value) { this.yearOffset = value; }

    @JsonProperty("month")
    public Long getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(Long value) { this.month = value; }

    @JsonProperty("date")
    public Long getDate() { return date; }
    @JsonProperty("date")
    public void setDate(Long value) { this.date = value; }

    @JsonProperty("addDay")
    public Long getAddDay() { return addDay; }
    @JsonProperty("addDay")
    public void setAddDay(Long value) { this.addDay = value; }
}

// The20250305.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250305 {
    private String id;
    private LocalDate date;
    private The20250305_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private Rank rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private String[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private Color[] colors;
    private Object[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private FromCalendarID fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250305_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250305_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public Rank getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(Rank value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public String[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(String[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public Color[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(Color[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public Object[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(Object[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public FromCalendarID getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(FromCalendarID value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// Color.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Color {
    PURPLE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PURPLE: return "PURPLE";
        }
        return null;
    }

    @JsonCreator
    public static Color forValue(String value) throws IOException {
        if (value.equals("PURPLE")) return PURPLE;
        throw new IOException("Cannot deserialize Color");
    }
}

// The20250305_DateDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class The20250305_DateDef {
    private DateFn dateFn;
    private long yearOffset;

    @JsonProperty("dateFn")
    public DateFn getDateFn() { return dateFn; }
    @JsonProperty("dateFn")
    public void setDateFn(DateFn value) { this.dateFn = value; }

    @JsonProperty("yearOffset")
    public long getYearOffset() { return yearOffset; }
    @JsonProperty("yearOffset")
    public void setYearOffset(long value) { this.yearOffset = value; }
}

// DateFn.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum DateFn {
    ASH_WEDNESDAY;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ASH_WEDNESDAY: return "ashWednesday";
        }
        return null;
    }

    @JsonCreator
    public static DateFn forValue(String value) throws IOException {
        if (value.equals("ashWednesday")) return ASH_WEDNESDAY;
        throw new IOException("Cannot deserialize DateFn");
    }
}

// Period.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Period {
    PRESENTATION_OF_THE_LORD_TO_HOLY_THURSDAY;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PRESENTATION_OF_THE_LORD_TO_HOLY_THURSDAY: return "PRESENTATION_OF_THE_LORD_TO_HOLY_THURSDAY";
        }
        return null;
    }

    @JsonCreator
    public static Period forValue(String value) throws IOException {
        if (value.equals("PRESENTATION_OF_THE_LORD_TO_HOLY_THURSDAY")) return PRESENTATION_OF_THE_LORD_TO_HOLY_THURSDAY;
        throw new IOException("Cannot deserialize Period");
    }
}

// The20250306.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250306 {
    private String id;
    private LocalDate date;
    private The20250306_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private Precedence precedence;
    private Rank rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250306_I18NDef[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private Color[] colors;
    private Object[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private FromCalendarID fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250306_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250306_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public Precedence getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(Precedence value) { this.precedence = value; }

    @JsonProperty("rank")
    public Rank getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(Rank value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250306_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250306_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public Color[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(Color[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public Object[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(Object[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public FromCalendarID getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(FromCalendarID value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// The20250306_DateDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class The20250306_DateDef {
    private DateFn dateFn;
    private long addDay;
    private long yearOffset;

    @JsonProperty("dateFn")
    public DateFn getDateFn() { return dateFn; }
    @JsonProperty("dateFn")
    public void setDateFn(DateFn value) { this.dateFn = value; }

    @JsonProperty("addDay")
    public long getAddDay() { return addDay; }
    @JsonProperty("addDay")
    public void setAddDay(long value) { this.addDay = value; }

    @JsonProperty("yearOffset")
    public long getYearOffset() { return yearOffset; }
    @JsonProperty("yearOffset")
    public void setYearOffset(long value) { this.yearOffset = value; }
}

// The20250306_I18NDef.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = The20250306_I18NDef.Deserializer.class)
@JsonSerialize(using = The20250306_I18NDef.Serializer.class)
public class The20250306_I18NDef {
    public TentacledI18NDef tentacledI18NDefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<The20250306_I18NDef> {
        @Override
        public The20250306_I18NDef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            The20250306_I18NDef value = new The20250306_I18NDef();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.tentacledI18NDefValue = jsonParser.readValueAs(TentacledI18NDef.class);
                    break;
                default: throw new IOException("Cannot deserialize The20250306_I18NDef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<The20250306_I18NDef> {
        @Override
        public void serialize(The20250306_I18NDef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.tentacledI18NDefValue != null) {
                jsonGenerator.writeObject(obj.tentacledI18NDefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("The20250306_I18NDef must not be null");
        }
    }
}

// TentacledI18NDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class TentacledI18NDef {
    private long dow;

    @JsonProperty("dow")
    public long getDow() { return dow; }
    @JsonProperty("dow")
    public void setDow(long value) { this.dow = value; }
}

// Precedence.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Precedence {
    PRIVILEGED_WEEKDAY_9;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PRIVILEGED_WEEKDAY_9: return "PRIVILEGED_WEEKDAY_9";
        }
        return null;
    }

    @JsonCreator
    public static Precedence forValue(String value) throws IOException {
        if (value.equals("PRIVILEGED_WEEKDAY_9")) return PRIVILEGED_WEEKDAY_9;
        throw new IOException("Cannot deserialize Precedence");
    }
}

// The2025030.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The2025030 {
    private String id;
    private LocalDate date;
    private The20250304_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250306_I18NDef[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private Color[] colors;
    private String[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private String fromCalendarID;
    private Object[] fromExtendedCalendars;
    private The20250306 weekday;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250304_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250304_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250306_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250306_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public Color[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(Color[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public String[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(String[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public String getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(String value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }

    @JsonProperty("weekday")
    public The20250306 getWeekday() { return weekday; }
    @JsonProperty("weekday")
    public void setWeekday(The20250306 value) { this.weekday = value; }
}

// The202503.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The202503 {
    private String id;
    private LocalDate date;
    private The20250306_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250302_I18NDef[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private String[] colors;
    private Object[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private FromCalendarID fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250306_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250306_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250302_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250302_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public String[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(String[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public Object[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(Object[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public FromCalendarID getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(FromCalendarID value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// The20250310.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250310 {
    private String id;
    private LocalDate date;
    private The20250306_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private Precedence precedence;
    private Rank rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250310_I18NDef[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private Color[] colors;
    private Object[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private FromCalendarID fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250306_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250306_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public Precedence getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(Precedence value) { this.precedence = value; }

    @JsonProperty("rank")
    public Rank getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(Rank value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250310_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250310_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public Color[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(Color[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public Object[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(Object[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public FromCalendarID getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(FromCalendarID value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// The20250310_I18NDef.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = The20250310_I18NDef.Deserializer.class)
@JsonSerialize(using = The20250310_I18NDef.Serializer.class)
public class The20250310_I18NDef {
    public PurpleI18NDef purpleI18NDefValue;
    public I18NDefEnum enumValue;

    static class Deserializer extends JsonDeserializer<The20250310_I18NDef> {
        @Override
        public The20250310_I18NDef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            The20250310_I18NDef value = new The20250310_I18NDef();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = I18NDefEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.purpleI18NDefValue = jsonParser.readValueAs(PurpleI18NDef.class);
                    break;
                default: throw new IOException("Cannot deserialize The20250310_I18NDef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<The20250310_I18NDef> {
        @Override
        public void serialize(The20250310_I18NDef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleI18NDefValue != null) {
                jsonGenerator.writeObject(obj.purpleI18NDefValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            throw new IOException("The20250310_I18NDef must not be null");
        }
    }
}

// I18NDefEnum.java

package com.apiverve.liturgicalcalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum I18NDefEnum {
    SEASONS_LENT_WEEKDAY;

    @JsonValue
    public String toValue() {
        switch (this) {
            case SEASONS_LENT_WEEKDAY: return "seasons:lent.weekday";
        }
        return null;
    }

    @JsonCreator
    public static I18NDefEnum forValue(String value) throws IOException {
        if (value.equals("seasons:lent.weekday")) return SEASONS_LENT_WEEKDAY;
        throw new IOException("Cannot deserialize I18NDefEnum");
    }
}

// The2025031.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The2025031 {
    private String id;
    private LocalDate date;
    private The20250304_DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private The20250301_I18NDef[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private Color[] colors;
    private String[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private String fromCalendarID;
    private Object[] fromExtendedCalendars;
    private The20250310 weekday;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250304_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250304_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public The20250301_I18NDef[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(The20250301_I18NDef[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public Color[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(Color[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public String[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(String[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public String getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(String value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }

    @JsonProperty("weekday")
    public The20250310 getWeekday() { return weekday; }
    @JsonProperty("weekday")
    public void setWeekday(The20250310 value) { this.weekday = value; }
}

// The20250319.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250319 {
    private String id;
    private LocalDate date;
    private The20250319_DateDef dateDef;
    private DateException[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private String[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private String[] colors;
    private String[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private String fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public The20250319_DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(The20250319_DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public DateException[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(DateException[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public String[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(String[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public String[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(String[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public String[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(String[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public String getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(String value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}

// The20250319_DateDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class The20250319_DateDef {
    private long month;
    private long date;

    @JsonProperty("month")
    public long getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(long value) { this.month = value; }

    @JsonProperty("date")
    public long getDate() { return date; }
    @JsonProperty("date")
    public void setDate(long value) { this.date = value; }
}

// DateException.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class DateException {
    private Long ifIsDayOfWeek;
    private SetDate setDate;
    private IfIsBetween ifIsBetween;

    @JsonProperty("ifIsDayOfWeek")
    public Long getIfIsDayOfWeek() { return ifIsDayOfWeek; }
    @JsonProperty("ifIsDayOfWeek")
    public void setIfIsDayOfWeek(Long value) { this.ifIsDayOfWeek = value; }

    @JsonProperty("setDate")
    public SetDate getSetDate() { return setDate; }
    @JsonProperty("setDate")
    public void setSetDate(SetDate value) { this.setDate = value; }

    @JsonProperty("ifIsBetween")
    public IfIsBetween getIfIsBetween() { return ifIsBetween; }
    @JsonProperty("ifIsBetween")
    public void setIfIsBetween(IfIsBetween value) { this.ifIsBetween = value; }
}

// IfIsBetween.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class IfIsBetween {
    private DateDef from;
    private DateDef to;
    private boolean inclusive;

    @JsonProperty("from")
    public DateDef getFrom() { return from; }
    @JsonProperty("from")
    public void setFrom(DateDef value) { this.from = value; }

    @JsonProperty("to")
    public DateDef getTo() { return to; }
    @JsonProperty("to")
    public void setTo(DateDef value) { this.to = value; }

    @JsonProperty("inclusive")
    public boolean getInclusive() { return inclusive; }
    @JsonProperty("inclusive")
    public void setInclusive(boolean value) { this.inclusive = value; }
}

// DateDef.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class DateDef {
    private String dateFn;

    @JsonProperty("dateFn")
    public String getDateFn() { return dateFn; }
    @JsonProperty("dateFn")
    public void setDateFn(String value) { this.dateFn = value; }
}

// SetDate.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;

public class SetDate {
    private Long addDay;
    private String dateFn;
    private Long subtractDay;

    @JsonProperty("addDay")
    public Long getAddDay() { return addDay; }
    @JsonProperty("addDay")
    public void setAddDay(Long value) { this.addDay = value; }

    @JsonProperty("dateFn")
    public String getDateFn() { return dateFn; }
    @JsonProperty("dateFn")
    public void setDateFn(String value) { this.dateFn = value; }

    @JsonProperty("subtractDay")
    public Long getSubtractDay() { return subtractDay; }
    @JsonProperty("subtractDay")
    public void setSubtractDay(Long value) { this.subtractDay = value; }
}

// The20250325.java

package com.apiverve.liturgicalcalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class The20250325 {
    private String id;
    private LocalDate date;
    private DateDef dateDef;
    private Object[] dateExceptions;
    private Object[] alternativeTransferDateDefs;
    private String precedence;
    private String rank;
    private boolean allowSimilarRankItems;
    private boolean isHolyDayOfObligation;
    private boolean isOptional;
    private String[] i18NDef;
    private Season[] seasons;
    private Period[] periods;
    private String[] colors;
    private String[] commonsDef;
    private Object[] martyrology;
    private Object[] titles;
    private Calendar calendar;
    private Cycles cycles;
    private String fromCalendarID;
    private Object[] fromExtendedCalendars;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("dateDef")
    public DateDef getDateDef() { return dateDef; }
    @JsonProperty("dateDef")
    public void setDateDef(DateDef value) { this.dateDef = value; }

    @JsonProperty("dateExceptions")
    public Object[] getDateExceptions() { return dateExceptions; }
    @JsonProperty("dateExceptions")
    public void setDateExceptions(Object[] value) { this.dateExceptions = value; }

    @JsonProperty("alternativeTransferDateDefs")
    public Object[] getAlternativeTransferDateDefs() { return alternativeTransferDateDefs; }
    @JsonProperty("alternativeTransferDateDefs")
    public void setAlternativeTransferDateDefs(Object[] value) { this.alternativeTransferDateDefs = value; }

    @JsonProperty("precedence")
    public String getPrecedence() { return precedence; }
    @JsonProperty("precedence")
    public void setPrecedence(String value) { this.precedence = value; }

    @JsonProperty("rank")
    public String getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(String value) { this.rank = value; }

    @JsonProperty("allowSimilarRankItems")
    public boolean getAllowSimilarRankItems() { return allowSimilarRankItems; }
    @JsonProperty("allowSimilarRankItems")
    public void setAllowSimilarRankItems(boolean value) { this.allowSimilarRankItems = value; }

    @JsonProperty("isHolyDayOfObligation")
    public boolean getIsHolyDayOfObligation() { return isHolyDayOfObligation; }
    @JsonProperty("isHolyDayOfObligation")
    public void setIsHolyDayOfObligation(boolean value) { this.isHolyDayOfObligation = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("i18nDef")
    public String[] getI18NDef() { return i18NDef; }
    @JsonProperty("i18nDef")
    public void setI18NDef(String[] value) { this.i18NDef = value; }

    @JsonProperty("seasons")
    public Season[] getSeasons() { return seasons; }
    @JsonProperty("seasons")
    public void setSeasons(Season[] value) { this.seasons = value; }

    @JsonProperty("periods")
    public Period[] getPeriods() { return periods; }
    @JsonProperty("periods")
    public void setPeriods(Period[] value) { this.periods = value; }

    @JsonProperty("colors")
    public String[] getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(String[] value) { this.colors = value; }

    @JsonProperty("commonsDef")
    public String[] getCommonsDef() { return commonsDef; }
    @JsonProperty("commonsDef")
    public void setCommonsDef(String[] value) { this.commonsDef = value; }

    @JsonProperty("martyrology")
    public Object[] getMartyrology() { return martyrology; }
    @JsonProperty("martyrology")
    public void setMartyrology(Object[] value) { this.martyrology = value; }

    @JsonProperty("titles")
    public Object[] getTitles() { return titles; }
    @JsonProperty("titles")
    public void setTitles(Object[] value) { this.titles = value; }

    @JsonProperty("calendar")
    public Calendar getCalendar() { return calendar; }
    @JsonProperty("calendar")
    public void setCalendar(Calendar value) { this.calendar = value; }

    @JsonProperty("cycles")
    public Cycles getCycles() { return cycles; }
    @JsonProperty("cycles")
    public void setCycles(Cycles value) { this.cycles = value; }

    @JsonProperty("fromCalendarId")
    public String getFromCalendarID() { return fromCalendarID; }
    @JsonProperty("fromCalendarId")
    public void setFromCalendarID(String value) { this.fromCalendarID = value; }

    @JsonProperty("fromExtendedCalendars")
    public Object[] getFromExtendedCalendars() { return fromExtendedCalendars; }
    @JsonProperty("fromExtendedCalendars")
    public void setFromExtendedCalendars(Object[] value) { this.fromExtendedCalendars = value; }
}