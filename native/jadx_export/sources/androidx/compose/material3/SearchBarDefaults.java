package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: SearchBar.android.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÈ\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c0 2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020#2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u00101J&\u0010-\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J0\u0010-\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00108\u001a\u00020.H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u008a\u0001\u00108\u001a\u00020.2\b\b\u0002\u0010;\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010F\u001a\u0002042\b\b\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u009e\u0001\u00108\u001a\u00020.2\b\b\u0002\u0010J\u001a\u0002042\b\b\u0002\u0010K\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010L\u001a\u0002042\b\b\u0002\u0010M\u001a\u0002042\b\b\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010OR$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "ShadowElevation", "getShadowElevation-D9Ej5fM", "TonalElevation", "getTonalElevation-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "InputField", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "expanded", "", "onExpandedChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "colors", "Landroidx/compose/material3/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m3190getLevel0D9Ej5fM();
    private static final float ShadowElevation = ElevationTokens.INSTANCE.m3190getLevel0D9Ej5fM();
    private static final float Elevation = TonalElevation;
    private static final float InputFieldHeight = SearchBarTokens.INSTANCE.m3491getContainerHeightD9Ej5fM();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* renamed from: getElevation-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2432getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    /* renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2438getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m2437getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2435getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM, reason: not valid java name */
    public final float m2436getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -971556142, "C349@15770L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-971556142, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:349)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getFullScreenShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1665502056, "C353@15944L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1665502056, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:353)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getDockedShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1006952150, "C357@16094L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006952150, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:357)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2112270157, "C361@16229L10:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112270157, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:361)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return statusBars;
    }

    /* renamed from: colors-dgg9oW8, reason: not valid java name */
    public final SearchBarColors m2434colorsdgg9oW8(long containerColor, long dividerColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1507037523, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)375@16778L5,376@16845L5,381@17019L18:SearchBar.android.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        long dividerColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), $composer, 6) : dividerColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1507037523, $changed, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:378)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(containerColor2, dividerColor2, m2440inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, ($changed << 6) & 57344, 16383), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return searchBarColors;
    }

    /* renamed from: inputFieldColors-ITpI4ow, reason: not valid java name */
    public final TextFieldColors m2440inputFieldColorsITpI4ow(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long cursorColor, SelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -602148837, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)410@18829L5,411@18903L5,413@18998L5,416@19154L5,417@19233L7,418@19316L5,419@19399L5,421@19507L5,424@19683L5,425@19768L5,427@19878L5,430@20056L5,431@20142L5,433@20244L5,437@20389L847:SearchBar.android.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : unfocusedTextColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledTextColor2 = Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long cursorColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6) : cursorColor;
        if ((i & 16) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedLeadingIconColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((i & 128) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4185copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value2) : FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value2) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long focusedTrailingIconColor2 = (i & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((i & 1024) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4185copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value3) : FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value3) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long focusedPlaceholderColor2 = (i & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6) : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (i & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6) : unfocusedPlaceholderColor;
        if ((i & 8192) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4185copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value4) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value4) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602148837, $changed, $changed1, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:437)");
        }
        TextFieldColors textFieldColorsM2692colors0hiis_0 = TextFieldDefaults.INSTANCE.m2692colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, 0L, 0L, 0L, 0L, 0L, cursorColor2, 0L, selectionColors2, 0L, 0L, 0L, 0L, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, 0L, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, 0L, 0L, 0L, 0L, 0L, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed << 15) & 234881024), (($changed >> 12) & 14) | (458752 & $changed) | (3670016 & $changed) | ($changed & 29360128) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (29360128 & ($changed1 << 18)) | (($changed1 << 18) & 234881024) | (($changed1 << 18) & 1879048192), 0, 3072, 1204058872, 4095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2692colors0hiis_0;
    }

    /* JADX WARN: Removed duplicated region for block: B:243:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0629  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void InputField(final java.lang.String r78, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r79, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r80, final boolean r81, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r82, androidx.compose.ui.Modifier r83, boolean r84, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, androidx.compose.material3.TextFieldColors r88, androidx.compose.foundation.interaction.MutableInteractionSource r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1637
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.InputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. `inputFieldColors` should be passed explicitly to the input field. This parameter will be removed in a future version of the library.", replaceWith = @ReplaceWith(expression = "colors(containerColor, dividerColor)", imports = {}))
    /* renamed from: colors-Klgx-Pg, reason: not valid java name */
    public final SearchBarColors m2433colorsKlgxPg(long containerColor, long dividerColor, TextFieldColors inputFieldColors, Composer $composer, int $changed, int i) {
        int i2;
        TextFieldColors inputFieldColors2;
        ComposerKt.sourceInformationMarkerStart($composer, -1216168196, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)586@27706L5,587@27773L5,588@27824L18:SearchBar.android.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        long dividerColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), $composer, 6) : dividerColor;
        if ((i & 4) != 0) {
            i2 = $changed;
            inputFieldColors2 = m2440inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, ($changed << 3) & 57344, 16383);
        } else {
            i2 = $changed;
            inputFieldColors2 = inputFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, i2, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:590)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(containerColor2, dividerColor2, inputFieldColors2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return searchBarColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2439inputFieldColorsuKgnY(long textColor, long disabledTextColor, long cursorColor, SelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 355927049, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)599@28228L5,601@28323L5,604@28479L5,605@28558L7,606@28641L5,607@28724L5,609@28832L5,612@29008L5,613@29093L5,615@29203L5,618@29374L5,620@29476L5,624@29586L825:SearchBar.android.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            long value = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledTextColor2 = Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long cursorColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6) : cursorColor;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedLeadingIconColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((i & 64) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4185copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value2) : FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value2) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long focusedTrailingIconColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (i & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((i & 512) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4185copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value3) : FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value3) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long placeholderColor2 = (i & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6) : placeholderColor;
        if ((i & 2048) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4185copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value4) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value4) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(355927049, $changed, $changed1, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:624)");
        }
        long textColor3 = textColor2;
        long disabledLeadingIconColor3 = disabledLeadingIconColor2;
        long disabledLeadingIconColor4 = unfocusedTrailingIconColor2;
        long unfocusedTrailingIconColor3 = placeholderColor2;
        long placeholderColor3 = disabledPlaceholderColor2;
        long cursorColor3 = cursorColor2;
        long cursorColor4 = focusedLeadingIconColor2;
        long focusedLeadingIconColor3 = unfocusedLeadingIconColor2;
        long unfocusedLeadingIconColor3 = focusedTrailingIconColor2;
        long focusedTrailingIconColor3 = disabledTrailingIconColor2;
        TextFieldColors textFieldColorsM2440inputFieldColorsITpI4ow = m2440inputFieldColorsITpI4ow(textColor3, textColor3, disabledTextColor2, cursorColor3, selectionColors2, cursorColor4, focusedLeadingIconColor3, disabledLeadingIconColor3, unfocusedLeadingIconColor3, disabledLeadingIconColor4, focusedTrailingIconColor3, unfocusedTrailingIconColor3, unfocusedTrailingIconColor3, placeholderColor3, $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752) | (($changed << 3) & 3670016) | (($changed << 3) & 29360128) | (($changed << 3) & 234881024) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2440inputFieldColorsITpI4ow;
    }
}
