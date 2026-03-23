package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListItemDefaults {
    public static final int $stable = 0;
    public static final ListItemDefaults INSTANCE = new ListItemDefaults();
    private static final float Elevation = ListTokens.INSTANCE.m3319getListItemContainerElevationD9Ej5fM();

    private ListItemDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2212getElevationD9Ej5fM() {
        return Elevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -496871597, "C535@21280L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496871597, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:535)");
        }
        Shape value = ShapesKt.getValue(ListTokens.INSTANCE.getListItemContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1253579929, "C539@21445L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1253579929, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:539)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getContentColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1076068327, "C543@21606L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1076068327, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:543)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    /* renamed from: colors-J08w3-E, reason: not valid java name */
    public final ListItemColors m2211colorsJ08w3E(long containerColor, long headlineColor, long leadingIconColor, long overlineColor, long supportingColor, long trailingIconColor, long disabledHeadlineColor, long disabledLeadingIconColor, long disabledTrailingIconColor, Composer $composer, int $changed, int i) {
        long disabledHeadlineColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -352515689, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)563@22671L5,564@22743L5,565@22820L5,566@22891L5,567@22970L5,568@23049L5,570@23149L5,574@23342L5,578@23539L5:ListItem.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), $composer, 6) : containerColor;
        long headlineColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), $composer, 6) : headlineColor;
        long leadingIconColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLeadingIconColor(), $composer, 6) : leadingIconColor;
        long overlineColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemOverlineColor(), $composer, 6) : overlineColor;
        long supportingColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemSupportingTextColor(), $composer, 6) : supportingColor;
        long trailingIconColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemTrailingIconColor(), $composer, 6) : trailingIconColor;
        if ((i & 64) != 0) {
            long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemDisabledLabelTextColor(), $composer, 6);
            disabledHeadlineColor2 = Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f);
        } else {
            disabledHeadlineColor2 = disabledHeadlineColor;
        }
        if ((i & 128) != 0) {
            long value2 = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4185copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value2) : ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value2) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 256) != 0) {
            long value3 = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4185copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value3) : ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value3) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-352515689, $changed, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:582)");
        }
        ListItemColors listItemColors = new ListItemColors(containerColor2, headlineColor2, leadingIconColor2, overlineColor2, supportingColor2, trailingIconColor2, disabledHeadlineColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return listItemColors;
    }
}
